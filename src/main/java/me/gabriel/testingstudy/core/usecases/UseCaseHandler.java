package me.gabriel.testingstudy.core.usecases;

import java.util.function.Function;

import static me.gabriel.testingstudy.core.usecases.UseCase.InputValue;
import static me.gabriel.testingstudy.core.usecases.UseCase.OutputValue;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
public interface UseCaseHandler {

  <R, I extends InputValue, O extends OutputValue> R handle(
    UseCase<I, O> useCase,
    I input,
    Function<O, R> outputMapper
  );

}
