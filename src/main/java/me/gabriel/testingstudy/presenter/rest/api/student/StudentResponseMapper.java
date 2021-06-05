package me.gabriel.testingstudy.presenter.rest.api.student;

import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.presenter.rest.api.dto.StudentResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
public final class StudentResponseMapper {

  private StudentResponseMapper(){}

  public static ResponseEntity<StudentResponse> map(Student student) {
    return ResponseEntity.ok(StudentResponse.from(student));
  }

  public static ResponseEntity<List<StudentResponse>> map(List<Student> students) {
    return ResponseEntity.ok(StudentResponse.from(students));
  }

}
