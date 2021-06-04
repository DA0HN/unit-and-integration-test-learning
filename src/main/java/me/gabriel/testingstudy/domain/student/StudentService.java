package me.gabriel.testingstudy.domain.student;

import me.gabriel.testingstudy.domain.student.exception.EmailAlreadyInUseException;
import me.gabriel.testingstudy.domain.student.exception.StudentNotFoundException;

import java.util.List;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
public interface StudentService {
  List<StudentDto> findAll();
  StudentDto create(StudentDto student) throws EmailAlreadyInUseException;
  void deleteById(Long id) throws StudentNotFoundException;
}
