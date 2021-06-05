package me.gabriel.testingstudy.presenter.rest.api.student;

import lombok.AllArgsConstructor;
import me.gabriel.testingstudy.core.usecases.UseCaseHandler;
import me.gabriel.testingstudy.core.usecases.student.CreateStudentUseCase;
import me.gabriel.testingstudy.core.usecases.student.DeleteStudentByIdUseCase;
import me.gabriel.testingstudy.core.usecases.student.FindAllStudentUseCase;
import me.gabriel.testingstudy.presenter.rest.api.dto.StudentRequest;
import me.gabriel.testingstudy.presenter.rest.api.dto.StudentResponse;
import me.gabriel.testingstudy.presenter.rest.api.shared.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

  private final UseCaseHandler useCaseHandler;
  private final CreateStudentUseCase createStudentUseCase;
  private final DeleteStudentByIdUseCase deleteStudentByIdUseCase;
  private final FindAllStudentUseCase findAllStudentUseCase;

  @GetMapping
  public ResponseEntity<List<StudentResponse>> findAll() {
    return useCaseHandler.handle(
      findAllStudentUseCase,
      new FindAllStudentUseCase.InputValue(),
      outputValue -> StudentResponseMapper.map(outputValue.getStudents())
    );
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create(@Valid @RequestBody StudentRequest studentRequest) {
    return useCaseHandler.handle(
      createStudentUseCase,
      StudentRequestMapper.map(studentRequest),
      outputValue -> ApiResponse.map(true, "Student successfully created")
    );
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> deleteById(@PathVariable Long id) {
    return useCaseHandler.handle(
      deleteStudentByIdUseCase,
      new DeleteStudentByIdUseCase.InputValue(id),
      outputValue -> ApiResponse.map(true, "Student successfully deleted")
    );
  }
}
