package me.gabriel.testingstudy.domain.student;

import me.gabriel.testingstudy.domain.student.exception.EmailAlreadyInUseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static me.gabriel.testingstudy.domain.student.StudentFactory.makeStudent;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

  @Mock
  private StudentRepository studentRepository;

  private StudentService sut;

  @BeforeEach
  void setUp() {
    this.sut = new StudentServiceImpl(studentRepository);
  }

  @Test
  void whenThereAreRegisteredStudentsThenShouldListAll() {

    sut.findAll();

    verify(studentRepository, times(1)).findAll();
  }

  @Test
  void whenStudentDoesNotHaveRegisteredEmailThenShouldBeCreated() {
    var student = makeStudent();

    sut.create(student);

    verify(studentRepository, times(1)).isEmailAlreadyInUse(anyString());
    verify(studentRepository, times(1)).save(student);
  }

  @Test
  void whenStudentHasRegisteredEmailShouldThrowEmailAlreadyInUseException() {

    var student = makeStudent();

    when(studentRepository.isEmailAlreadyInUse(anyString())).thenReturn(true);

    assertThrows(
      EmailAlreadyInUseException.class,
      () -> sut.create(student)
    );

    verify(studentRepository, times(1)).isEmailAlreadyInUse(anyString());
    verify(studentRepository, never()).save(any(Student.class));
  }

  @Test
  void deleteById() {
  }
}
