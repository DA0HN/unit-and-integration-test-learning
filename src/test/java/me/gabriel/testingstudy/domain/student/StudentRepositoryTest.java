package me.gabriel.testingstudy.domain.student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static me.gabriel.testingstudy.domain.student.StudentFactory.makeStudent;
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


  @Test
  void itShouldCheckIfStudentEmailAlreadyRegistered() {

    var student = makeStudent();

    sut.save(student);

    var isEmailRegistered = sut.isEmailAlreadyRegistered(student.getEmail());

    assertThat(isEmailRegistered).isTrue();
  }

  @Test
  void itShouldCheckIfStudentEmailIsNotRegistered() {

    var student = makeStudent();

    var isEmailRegistered = sut.isEmailAlreadyRegistered(student.getEmail());

    assertThat(isEmailRegistered).isFalse();
  }
}

