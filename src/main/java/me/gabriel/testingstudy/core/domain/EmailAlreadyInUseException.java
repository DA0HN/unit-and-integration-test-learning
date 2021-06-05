package me.gabriel.testingstudy.core.domain;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
public class EmailAlreadyInUseException extends DomainException {
  public EmailAlreadyInUseException(String message) {
    super(message);
  }
}
