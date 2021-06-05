package me.gabriel.testingstudy.presenter.rest.api.student;

import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.core.usecases.student.CreateStudentUseCase;
import me.gabriel.testingstudy.presenter.rest.api.dto.StudentRequest;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
public class StudentRequestMapper {

  private StudentRequestMapper() {
  }

  public static CreateStudentUseCase.InputValue map(StudentRequest studentRequest) {
    return new CreateStudentUseCase.InputValue(
      new Student(studentRequest.getName(), studentRequest.getEmail(), studentRequest.getGender())
    );
  }
}
