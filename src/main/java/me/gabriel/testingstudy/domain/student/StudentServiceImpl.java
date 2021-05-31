package me.gabriel.testingstudy.domain.student;

import lombok.AllArgsConstructor;
import me.gabriel.testingstudy.domain.student.exception.EmailAlreadyInUseException;
import me.gabriel.testingstudy.domain.student.exception.StudentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

  private final StudentRepository repository;

  @Override public List<Student> findAll() {
    return repository.findAll();
  }

  @Override public void create(Student student) throws EmailAlreadyInUseException {
    var isEmailInUse = repository.isEmailAlreadyInUse(student.getEmail());

    if(isEmailInUse) {
      throw new EmailAlreadyInUseException("Email " + student.getEmail() + " already in use.");
    }

    repository.save(student);
  }

  @Override public void deleteById(Long id) throws StudentNotFoundException {

    if(id == null) {
      throw new IllegalArgumentException("Id " + id + " cannot be null");
    }

    if(!repository.existsById(id)) {
      throw new StudentNotFoundException("Student with id " + id + " does not exists");
    }

    repository.deleteById(id);
  }
}
