package me.gabriel.testingstudy.data.db.mappers;

import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.data.db.entities.StudentEntity;

/**
 * Created by daohn on 01/06/2021
 * @author daohn
 * @since 01/06/2021
 */
public interface StudentMapper {

  StudentEntity fromStudentDtoToStudentEntity(Student dto);
  Student fromStudentEntityToStudentDto(StudentEntity entity);

}
