package me.gabriel.testingstudy.core.usecases;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
public interface UseCase<I extends UseCase.InputValue, O extends UseCase.OutputValue>{

  O handle(I input);

  interface InputValue {
  }

  interface OutputValue {
  }

}
