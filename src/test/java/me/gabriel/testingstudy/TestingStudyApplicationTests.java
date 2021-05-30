package me.gabriel.testingstudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class TestingStudyApplicationTests {

  Calculator sut = new Calculator();


  @Test
  void itShouldAddTwoNumbers() {

    // given
    int numberOne = 20;
    int numberTwo = 30;

    // when
    var result = sut.add(numberOne, numberTwo);

    // then
    var expected = 50;
    assertThat(result).isEqualTo(expected);
  }

  private static class Calculator {
    int add(int a, int b) {
      return a + b;
    }
  }
}
