package me.gabriel.testingstudy.domain.student;

public class StudentFactory {

  static Student makeStudent() {
    return new Student(
      "name",
      "email@email.com",
      Gender.OTHER
    );
  }
}
