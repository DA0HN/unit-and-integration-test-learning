package me.gabriel.testingstudy.domain.student;

/**
 * Created by daohn on 01/06/2021
 * @author daohn
 * @since 01/06/2021
 */
public interface StudentMapper {

  Student fromStudentDtoToStudentEntity(StudentDto dto);
  StudentDto fromStudentEntityToStudentDto(Student entity);

}
