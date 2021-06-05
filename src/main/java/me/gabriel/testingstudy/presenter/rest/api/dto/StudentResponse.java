package me.gabriel.testingstudy.presenter.rest.api.dto;

import lombok.Value;
import me.gabriel.testingstudy.core.domain.Student;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@Value
public class StudentResponse {
  String name;
  String email;
  String gender;

  public static StudentResponse from(Student student) {
    return new StudentResponse(
      student.getName(),
      student.getEmail(),
      student.getGender()
    );
  }

  public static List<StudentResponse> from(List<Student> students) {
    return students.stream().map(StudentResponse::from).collect(Collectors.toList());
  }
}
