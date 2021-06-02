package me.gabriel.testingstudy.domain.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Created by daohn on 01/06/2021
 * @author daohn
 * @since 01/06/2021
 */
@ExtendWith(SpringExtension.class)
class StudentMapperTest {

  private StudentMapper studentMapper;

  @BeforeEach
  void setUp() {
    this.studentMapper = new StudentMapperImpl(new ModelMapper());
  }

  @Test
  void givenStudentDtoWhenIsValidThenShouldConvertToStudentEntity() {
    var studentDtoConvert = StudentFactory.createValidStudentDto();

    var expected = this.studentMapper.fromStudentDtoToStudentEntity(studentDtoConvert);

    assertAll(
      () -> assertEquals(expected.getName(), studentDtoConvert.getName()),
      () -> assertEquals(expected.getEmail(), studentDtoConvert.getEmail()),
      () -> assertEquals(expected.getGender().name(), studentDtoConvert.getGender()),
      () -> assertNull(expected.getId())
    );
  }

  @Test
  void givenStudentWhenIsValidThenShouldConvertToStudentDto() {
    var studentToConvert = StudentFactory.createValidStudent();

    var expected = this.studentMapper.fromStudentEntityToStudentDto(studentToConvert);

    assertAll(
      () -> assertEquals(expected.getName(), studentToConvert.getName()),
      () -> assertEquals(expected.getEmail(), studentToConvert.getEmail()),
      () -> assertEquals(expected.getGender(), studentToConvert.getGender().name())
    );

  }
}
