package me.gabriel.testingstudy.core.usecases.student;

import me.gabriel.testingstudy.core.domain.StudentNotFoundException;
import me.gabriel.testingstudy.core.usecases.UseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@ExtendWith(MockitoExtension.class)
class DeleteStudentByIdUseCaseTest {

  @Mock
  StudentRepository studentRepository;

  UseCase<DeleteStudentByIdUseCase.InputValue, DeleteStudentByIdUseCase.OutputValue> sut;

  private static final Long ID_VALID = 1L;
  private static final Long ID_INVALID = -1L;
  private static final Long ID_NULL = null;

  @BeforeEach
  void setUp() {
    this.sut = new DeleteStudentByIdUseCase(studentRepository);
  }

  @Test
  void givenStudentIdWhenIsValidThenShouldDeleteStudent() {
    when(studentRepository.existsById(ID_VALID)).thenReturn(true);

    sut.handle(new DeleteStudentByIdUseCase.InputValue(ID_VALID));

    verify(studentRepository, times(1)).existsById(ID_VALID);
    verify(studentRepository, times(1)).deleteById(ID_VALID);
  }

  @Test
  void givenStudentIdWhenIsNotValidThenShouldThrowStudentNotFoundException() {

    when(studentRepository.existsById(ID_INVALID)).thenReturn(false);

    var exception = assertThrows(
      StudentNotFoundException.class,
      () -> sut.handle(new DeleteStudentByIdUseCase.InputValue(ID_INVALID))
    );

    assertThat(exception).hasMessage("Student with id " + ID_INVALID + " does not exists");
    verify(studentRepository, times(1)).existsById(ID_INVALID);
    verify(studentRepository, never()).deleteById(ID_INVALID);
  }

  @Test
  void givenStudentIdWhenIsNullThenShouldThrowIllegalArgumentException() {
    assertThatThrownBy(() -> sut.handle(new DeleteStudentByIdUseCase.InputValue(ID_NULL)))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("Id " + ID_NULL + " cannot be null");

    verifyNoInteractions(studentRepository);
  }

}
