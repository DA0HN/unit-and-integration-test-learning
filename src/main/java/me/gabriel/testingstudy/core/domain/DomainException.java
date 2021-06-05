package me.gabriel.testingstudy.core.domain;

/**
 * Created by daohn on 04/06/2021
 * @author daohn
 * @since 04/06/2021
 */
public abstract class DomainException extends RuntimeException {

  protected DomainException(String message) {
    super(message);
  }

}
