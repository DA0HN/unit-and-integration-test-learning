package me.gabriel.testingstudy.domain.student;

class StudentFactory {

  static Student createValidStudent() {
    return new Student(
      "name",
      "email@email.com",
      Gender.OTHER
    );
  }

  public static StudentDto createValidStudentDto() {
    return new StudentDto(
      "name",
      "email@email.com",
      "OTHER"
    );
  }
}
