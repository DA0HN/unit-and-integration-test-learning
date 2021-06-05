package me.gabriel.testingstudy.utils;

import me.gabriel.testingstudy.core.domain.Gender;
import me.gabriel.testingstudy.core.domain.Student;
import me.gabriel.testingstudy.data.db.entities.StudentEntity;

public class StudentFactory {

  public static StudentEntity createValidStudentEntity() {
    return new StudentEntity(
      "name",
      "email@email.com",
      Gender.OTHER
    );
  }

  public static Student createValidStudent() {
    return new Student(
      "name",
      "email@email.com",
      "OTHER"
    );
  }
}
