package me.gabriel.testingstudy.domain.student;

class StudentFactory {

  static Student createValidStudent() {
    return new Student(
      "name",
      "email@email.com",
      Gender.OTHER
    );
  }
}
