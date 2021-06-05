package me.gabriel.testingstudy.presenter.usecases;

import me.gabriel.testingstudy.core.usecases.UseCase;
import me.gabriel.testingstudy.core.usecases.UseCaseHandler;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@Service
public class UseCaseHandlerImpl implements UseCaseHandler {


  @Override
  public <R, I extends UseCase.InputValue, O extends UseCase.OutputValue> R handle(UseCase<I, O> useCase, I input, Function<O, R> outputMapper) {
    return Stream.of(useCase.handle(input))
             .map(outputMapper)
             .findAny()
             .orElseThrow(IllegalStateException::new);
  }
}
