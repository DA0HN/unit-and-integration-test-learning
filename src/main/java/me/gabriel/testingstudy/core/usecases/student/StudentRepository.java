package me.gabriel.testingstudy.core.usecases.student;

import me.gabriel.testingstudy.core.domain.Student;

import java.util.List;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
public interface StudentRepository {
  List<Student> findAll();

  Student create(Student student);

  void deleteById(Long id);

  boolean existsById(Long id);

  boolean isEmailAlreadyInUse(String email);

}
