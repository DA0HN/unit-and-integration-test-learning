package me.gabriel.testingstudy.domain.student;

import me.gabriel.testingstudy.domain.student.exception.EmailAlreadyInUseException;
import me.gabriel.testingstudy.domain.student.exception.StudentNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static me.gabriel.testingstudy.domain.student.StudentFactory.createValidStudent;
import static me.gabriel.testingstudy.domain.student.StudentFactory.createValidStudentDto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

  @Mock
  private StudentRepository studentRepository;
  @Mock
  private StudentMapper studentMapper;

  private StudentService sut;

  private static final Long ID_VALID = 1L;
  private static final Long ID_INVALID = -1L;
  private static final Long ID_NULL = null;
  private static final Class<Student> STUDENT_CLASS = Student.class;
  private static final Class<StudentDto> STUDENT_DTO_CLASS = StudentDto.class;

  @BeforeEach
  void setUp() {
    this.sut = new StudentServiceImpl(studentRepository, studentMapper);
  }

  @Test
  void givenDatabaseWhenThereAreRegisteredStudentsThenShouldListAll() {
    when(studentRepository.findAll()).thenReturn(List.of(createValidStudent()));

    sut.findAll();

    verify(studentRepository, times(1)).findAll();
    verify(studentMapper, times(1)).fromStudentEntityToStudentDto(any(STUDENT_CLASS));
  }

  @Test
  void givenStudentWhenHasUnregisteredEmailThenShouldBeCreated() {
    var studentDto = createValidStudentDto();

    when(studentRepository.isEmailAlreadyInUse(anyString())).thenReturn(false);
    when(studentRepository.save(isA(STUDENT_CLASS))).thenReturn(createValidStudent());
    when(studentMapper.fromStudentDtoToStudentEntity(isA(STUDENT_DTO_CLASS))).thenReturn(createValidStudent());
    when(studentMapper.fromStudentEntityToStudentDto(isA(STUDENT_CLASS))).thenReturn(createValidStudentDto());

    sut.create(studentDto);

    verify(studentRepository, times(1)).isEmailAlreadyInUse(anyString());
    verify(studentRepository, times(1)).save(any(STUDENT_CLASS));
    verify(studentMapper, times(1)).fromStudentDtoToStudentEntity(any(STUDENT_DTO_CLASS));
    verify(studentMapper, times(1)).fromStudentEntityToStudentDto(any(STUDENT_CLASS));
  }

  @Test
  void givenStudentWhenHaveRegisteredEmailThenShouldThrowEmailAlreadyInUseException() {
    when(studentMapper.fromStudentDtoToStudentEntity(any(STUDENT_DTO_CLASS))).thenReturn(createValidStudent());
    when(studentRepository.isEmailAlreadyInUse(anyString())).thenReturn(true);

    var studentDto = createValidStudentDto();

    assertThrows(
      EmailAlreadyInUseException.class,
      () -> sut.create(studentDto)
    );

    verify(studentMapper, times(1)).fromStudentDtoToStudentEntity(any(STUDENT_DTO_CLASS));
    verify(studentMapper, never()).fromStudentEntityToStudentDto(any(STUDENT_CLASS));
    verify(studentRepository, times(1)).isEmailAlreadyInUse(anyString());
    verify(studentRepository, never()).save(any(STUDENT_CLASS));
  }

  @Test
  void givenStudentIdWhenIsValidThenShouldDeleteStudent() {
    when(studentRepository.existsById(ID_VALID)).thenReturn(true);

    sut.deleteById(ID_VALID);

    verify(studentRepository, times(1)).existsById(ID_VALID);
    verify(studentRepository, times(1)).deleteById(ID_VALID);
  }

  @Test
  void givenStudentIdWhenIsNotValidThenShouldThrowStudentNotFoundException() {

    when(studentRepository.existsById(ID_INVALID)).thenReturn(false);

    var exception = assertThrows(
      StudentNotFoundException.class,
      () -> sut.deleteById(ID_INVALID)
    );

    assertThat(exception).hasMessage("Student with id " + ID_INVALID + " does not exists");
    verify(studentRepository, times(1)).existsById(ID_INVALID);
    verify(studentRepository, never()).deleteById(ID_INVALID);
  }

  @Test
  void givenStudentIdWhenIsNullThenShouldThrowIllegalArgumentException() {
    assertThatThrownBy(() -> sut.deleteById(ID_NULL))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("Id " + ID_NULL + " cannot be null");

    verifyNoInteractions(studentRepository);
  }
}
