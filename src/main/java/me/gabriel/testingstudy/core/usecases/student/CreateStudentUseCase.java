package me.gabriel.testingstudy.core.usecases.student;

import lombok.AllArgsConstructor;
import lombok.Value;
import me.gabriel.testingstudy.core.domain.EmailAlreadyInUseException;
import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.core.usecases.UseCase;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
@AllArgsConstructor
public class CreateStudentUseCase implements UseCase<CreateStudentUseCase.InputValue, CreateStudentUseCase.OutputValue> {

  private final StudentRepository studentRepository;

  @Override public OutputValue handle(InputValue input) {

    var student = input.getStudent();

    if(studentRepository.isEmailAlreadyInUse(student.getEmail())) {
      throw new EmailAlreadyInUseException("Email " + student.getEmail() + " already in use.");
    }

    var savedStudent = studentRepository.create(student);

    return new OutputValue(savedStudent);
  }


  @Value
  public static class InputValue implements UseCase.InputValue {
    Student student;
  }

  @Value
  public static class OutputValue implements UseCase.OutputValue {
    Student student;
  }

}
