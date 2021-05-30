package me.gabriel.testingstudy.domain.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@DataJpaTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository sut;


  @Test
  void itShouldCheckIfStudentEmailAlreadyRegistered() {

    var student = new Student(
      "name",
      "email@email.com",
      Gender.OTHER
    );

    sut.save(student);

    var isEmailRegistered = sut.isEmailAlreadyRegistered(student.getEmail());

    assertThat(isEmailRegistered).isTrue();
  }
}

