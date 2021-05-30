package me.gabriel.testingstudy.domain.student;

import java.util.List;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
public interface StudentService {
  List<Student> findAll();
  void create(Student student);
  void deleteById(Long id);
}
