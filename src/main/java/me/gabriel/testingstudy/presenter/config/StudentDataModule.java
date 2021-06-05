package me.gabriel.testingstudy.presenter.config;

import me.gabriel.testingstudy.core.usecases.student.StudentRepository;
import me.gabriel.testingstudy.data.db.mappers.StudentMapper;
import me.gabriel.testingstudy.data.db.mappers.StudentMapperImpl;
import me.gabriel.testingstudy.data.db.repositories.JpaStudentRepository;
import me.gabriel.testingstudy.data.db.repositories.StudentRepositoryAdapter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@Configuration
public class StudentDataModule {

  @Bean
  public StudentRepository studentRepository(JpaStudentRepository jpaStudentRepository, StudentMapper studentMapper) {
    return new StudentRepositoryAdapter(jpaStudentRepository, studentMapper);
  }

  @Bean
  public StudentMapper studentMapper(ModelMapper modelMapper) {
    return new StudentMapperImpl(modelMapper);
  }

  @Bean
  public ModelMapper modelMapper() {
    var modelMapper = new ModelMapper();
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    return modelMapper;
  }

}
