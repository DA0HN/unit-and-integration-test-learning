package me.gabriel.testingstudy.core.usecases.student;

import me.gabriel.testingstudy.core.domain.EmailAlreadyInUseException;
import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.core.usecases.UseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static me.gabriel.testingstudy.utils.StudentFactory.createValidStudent;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@ExtendWith(MockitoExtension.class)
class CreateStudentUseCaseTest {

  @Mock
  StudentRepository studentRepository;

  UseCase<CreateStudentUseCase.InputValue, CreateStudentUseCase.OutputValue> sut;

  private static final Class<Student> STUDENT_CLASS = Student.class;

  @BeforeEach
  void setUp() {
    this.sut = new CreateStudentUseCase(studentRepository);
  }


  @Test
  void givenStudentWhenHasUnregisteredEmailThenShouldBeCreated() {
    when(studentRepository.isEmailAlreadyInUse(anyString())).thenReturn(false);
    when(studentRepository.create(isA(STUDENT_CLASS))).thenReturn(createValidStudent());

    sut.handle(new CreateStudentUseCase.InputValue(createValidStudent()));

    verify(studentRepository, times(1)).isEmailAlreadyInUse(anyString());
    verify(studentRepository, times(1)).create(isA(STUDENT_CLASS));
  }

  @Test
  void givenStudentWhenHaveRegisteredEmailThenShouldThrowEmailAlreadyInUseException() {
    when(studentRepository.isEmailAlreadyInUse(anyString())).thenReturn(true);

    assertThrows(
      EmailAlreadyInUseException.class,
      () -> sut.handle(new CreateStudentUseCase.InputValue(createValidStudent()))
    );

    verify(studentRepository, times(1)).isEmailAlreadyInUse(anyString());
    verify(studentRepository, never()).create(any(STUDENT_CLASS));
  }
}
