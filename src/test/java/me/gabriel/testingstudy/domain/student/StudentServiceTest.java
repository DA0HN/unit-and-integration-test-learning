package me.gabriel.testingstudy.domain.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static me.gabriel.testingstudy.domain.student.StudentFactory.makeStudent;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

  @Mock
  private StudentRepository studentRepository;

  private StudentService sut;

  @BeforeEach
  void setUp() {
    this.sut = new StudentServiceImpl(studentRepository);
  }

  @Test
  void whenThereAreSavedStudentsShouldFindAll() {

    sut.findAll();

    verify(studentRepository, times(1)).findAll();
  }

  @Test
  void whenStudentHasNotRegisteredEmailShouldCreate() {
    var student = makeStudent();

    sut.create(student);

    verify(studentRepository, times(1)).save(student);
  }

  @Test
  void deleteById() {
  }
}
