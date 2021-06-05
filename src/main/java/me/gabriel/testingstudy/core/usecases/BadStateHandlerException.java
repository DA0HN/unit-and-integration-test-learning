package me.gabriel.testingstudy.core.usecases;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
public class BadStateHandlerException extends RuntimeException {

  public BadStateHandlerException(String message) {
    super(message);
  }
}
