package me.gabriel.testingstudy.domain.student;

import lombok.AllArgsConstructor;
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

  @Override public Student fromStudentDtoToStudentEntity(StudentDto dto) {
    return mapper.map(dto, Student.class);
  }

  @Override public StudentDto fromStudentEntityToStudentDto(Student entity) {
    return mapper.map(entity, StudentDto.class);
  }
}
