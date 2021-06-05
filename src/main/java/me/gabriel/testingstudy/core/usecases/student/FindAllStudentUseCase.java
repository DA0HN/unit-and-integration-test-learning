package me.gabriel.testingstudy.core.usecases.student;

import lombok.AllArgsConstructor;
import lombok.Value;
import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.core.usecases.UseCase;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
@AllArgsConstructor
public class FindAllStudentUseCase implements UseCase<FindAllStudentUseCase.InputValue, FindAllStudentUseCase.OutputValue> {

  private final StudentRepository studentRepository;

  @Override public OutputValue handle(InputValue input) {
    // new OutputValue(studentRepository.findAll());
    return studentRepository.findAll()
             .stream()
             .collect(collectingAndThen(toList(), OutputValue::new));
  }

  @Value
  public static class InputValue implements UseCase.InputValue {
  }

  @Value
  public static class OutputValue implements UseCase.OutputValue {
    List<Student> students;
  }
}
