package me.gabriel.testingstudy.core.usecases.student;

import me.gabriel.testingstudy.core.usecases.UseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static me.gabriel.testingstudy.utils.StudentFactory.createValidStudent;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@ExtendWith(MockitoExtension.class)
class FindAllStudentUseCaseTest {

  @Mock
  StudentRepository studentRepository;

  UseCase<FindAllStudentUseCase.InputValue, FindAllStudentUseCase.OutputValue> sut;

  @BeforeEach
  void setUp() {
    this.sut = new FindAllStudentUseCase(studentRepository);
  }

  @Test
  void givenDatabaseWhenThereAreRegisteredStudentsThenShouldListAll() {
    when(studentRepository.findAll()).thenReturn(List.of(createValidStudent()));

    sut.handle(new FindAllStudentUseCase.InputValue());

    verify(studentRepository, times(1)).findAll();
  }
}
