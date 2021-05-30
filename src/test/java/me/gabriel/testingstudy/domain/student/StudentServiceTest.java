package me.gabriel.testingstudy.domain.student;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
class StudentServiceTest {

  @Mock
  private StudentRepository studentRepository;

  private AutoCloseable autoCloseable;

  private StudentService sut;

  @BeforeEach
  void setUp() {
    this.autoCloseable = MockitoAnnotations.openMocks(this);
    this.sut = new StudentServiceImpl(studentRepository);
  }

  @AfterEach
  void tearDown() throws Exception {
    autoCloseable.close();
  }

  @Test
  void canFindAll() {

    sut.findAll();

    verify(studentRepository, times(1)).findAll();
  }

  @Test
  void create() {
  }

  @Test
  void deleteById() {
  }
}
