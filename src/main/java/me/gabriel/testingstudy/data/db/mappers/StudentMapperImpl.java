package me.gabriel.testingstudy.data.db.mappers;

import lombok.AllArgsConstructor;
import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.data.db.entities.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 * Created by daohn on 01/06/2021
 * @author daohn
 * @since 01/06/2021
 */
@Service
@AllArgsConstructor
public class StudentMapperImpl implements StudentMapper {

  private final ModelMapper mapper;

  @Override public StudentEntity fromStudentDtoToStudentEntity(Student dto) {
    return mapper.map(dto, StudentEntity.class);
  }

  @Override public Student fromStudentEntityToStudentDto(StudentEntity entity) {
    return mapper.map(entity, Student.class);
  }
}
