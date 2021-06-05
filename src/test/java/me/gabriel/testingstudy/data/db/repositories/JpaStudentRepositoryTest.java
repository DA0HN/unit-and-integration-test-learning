package me.gabriel.testingstudy.data.db.repositories;

import me.gabriel.testingstudy.data.db.usecases.JpaStudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static me.gabriel.testingstudy.utils.StudentFactory.createValidStudentEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@DataJpaTest
class JpaStudentRepositoryTest {

  @Autowired
  private JpaStudentRepository sut;

  @AfterEach
  void tearDown() {
    sut.deleteAll();
  }

  @Test
  void givenStudentEmailWhenRegisteredThenShouldReturnTrue() {

    var student = createValidStudentEntity();

    sut.save(student);

    var isEmailRegistered = sut.isEmailAlreadyInUse(student.getEmail());

    assertThat(isEmailRegistered).isTrue();
  }

  @Test
  void givenStudentEmailWhenUnregisteredThenShouldReturnFalse() {

    var student = createValidStudentEntity();

    var isEmailRegistered = sut.isEmailAlreadyInUse(student.getEmail());

    assertThat(isEmailRegistered).isFalse();
  }
}

