package me.gabriel.testingstudy.api;

import lombok.AllArgsConstructor;
import me.gabriel.testingstudy.domain.student.StudentDto;
import me.gabriel.testingstudy.domain.student.StudentService;
import org.springframework.http.HttpStatus;
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

  private final StudentService service;

  @GetMapping
  public ResponseEntity<List<StudentDto>> findAll() {
    var students = service.findAll();
    return ResponseEntity.ok(students);
  }

  @PostMapping
  public ResponseEntity<Void> create(@Valid @RequestBody StudentDto student) {
    service.create(student);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id) {
    service.deleteById(id);
    return ResponseEntity.accepted().build();
  }
}
