package me.gabriel.testingstudy.presenter.config;

import me.gabriel.testingstudy.core.usecases.student.CreateStudentUseCase;
import me.gabriel.testingstudy.core.usecases.student.DeleteStudentByIdUseCase;
import me.gabriel.testingstudy.core.usecases.student.FindAllStudentUseCase;
import me.gabriel.testingstudy.core.usecases.student.StudentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@Configuration
public class StudentDomainModule {

  @Bean
  public CreateStudentUseCase createStudentUseCase(StudentRepository studentRepository) {
    return new CreateStudentUseCase(studentRepository);
  }

  @Bean
  public DeleteStudentByIdUseCase deleteStudentByIdUseCase(StudentRepository studentRepository) {
    return new DeleteStudentByIdUseCase(studentRepository);
  }

  @Bean
  public FindAllStudentUseCase findAllStudentUseCase(StudentRepository studentRepository) {
    return new FindAllStudentUseCase(studentRepository);
  }
}
