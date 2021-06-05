package me.gabriel.testingstudy.core.usecases.student;

import lombok.AllArgsConstructor;
import lombok.Value;
import me.gabriel.testingstudy.core.domain.StudentNotFoundException;
import me.gabriel.testingstudy.core.usecases.UseCase;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
@AllArgsConstructor
public class DeleteStudentByIdUseCase implements UseCase<DeleteStudentByIdUseCase.InputValue,
                                                          DeleteStudentByIdUseCase.OutputValue> {

  private final StudentRepository studentRepository;

  @Override public OutputValue handle(InputValue input) {

    if(input.getId() == null) {
      throw new IllegalArgumentException("Id " + input.getId() + " cannot be null");
    }

    if(!studentRepository.existsById(input.getId())) {
      throw new StudentNotFoundException("Student with id " + input.getId() + " does not exists");
    }

    studentRepository.deleteById(input.getId());

    return new OutputValue();
  }

  @Value
  public static class InputValue implements UseCase.InputValue {
    Long id;
  }

  @Value
  public static class OutputValue implements UseCase.OutputValue {

  }

}
