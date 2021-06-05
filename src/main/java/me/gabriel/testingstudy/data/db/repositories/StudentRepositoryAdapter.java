package me.gabriel.testingstudy.data.db.repositories;

import lombok.AllArgsConstructor;
import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.core.usecases.student.StudentRepository;
import me.gabriel.testingstudy.data.db.mappers.StudentMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
@AllArgsConstructor
public class StudentRepositoryAdapter implements StudentRepository {

  private final JpaStudentRepository repository;
  private final StudentMapper mapper;

  @Override public List<Student> findAll() {
    return repository.findAll()
             .stream()
             .map(mapper::fromStudentEntityToStudentDto)
             .collect(Collectors.toList());
  }

  @Override public Student create(Student student) {
    var entity = mapper.fromStudentDtoToStudentEntity(student);

    repository.save(entity);

    return mapper.fromStudentEntityToStudentDto(entity);
  }

  @Override public void deleteById(Long id) {
    repository.deleteById(id);
  }

  @Override public boolean existsById(Long id) {
    return repository.existsById(id);
  }

  @Override public boolean isEmailAlreadyInUse(String email) {
    return repository.isEmailAlreadyInUse(email);
  }
}
