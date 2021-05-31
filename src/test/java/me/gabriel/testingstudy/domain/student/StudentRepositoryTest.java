package me.gabriel.testingstudy.domain.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static me.gabriel.testingstudy.domain.student.StudentFactory.createValidStudent;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@DataJpaTest
class StudentRepositoryTest {

  @Autowired
  private StudentRepository sut;

  @AfterEach
  void tearDown() {
    sut.deleteAll();
  }

  @Test
  void givenStudentEmailWhenRegisteredThenShouldReturnTrue() {

    var student = createValidStudent();

    sut.save(student);

    var isEmailRegistered = sut.isEmailAlreadyInUse(student.getEmail());

    assertThat(isEmailRegistered).isTrue();
  }

  @Test
  void givenStudentEmailWhenUnregisteredThenShouldReturnFalse() {

    var student = createValidStudent();

    var isEmailRegistered = sut.isEmailAlreadyInUse(student.getEmail());

    assertThat(isEmailRegistered).isFalse();
  }
}

