package me.gabriel.testingstudy.domain.student;

import me.gabriel.testingstudy.domain.student.exception.EmailAlreadyUsedException;
import me.gabriel.testingstudy.domain.student.exception.StudentNotFoundException;

import java.util.List;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
public interface StudentService {
  List<Student> findAll();
  void create(Student student) throws EmailAlreadyUsedException;
  void deleteById(Long id) throws StudentNotFoundException;
}
