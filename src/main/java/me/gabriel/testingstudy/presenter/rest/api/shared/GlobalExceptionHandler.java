package me.gabriel.testingstudy.presenter.rest.api.shared;

import me.gabriel.testingstudy.core.domain.DomainException;
import me.gabriel.testingstudy.core.domain.EmailAlreadyInUseException;
import me.gabriel.testingstudy.core.domain.StudentNotFoundException;
import me.gabriel.testingstudy.core.usecases.BadStateHandlerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DomainException.class)
  public ResponseEntity<ApiResponse> handleDomainException(DomainException exception) {
    return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(EmailAlreadyInUseException.class)
  public ResponseEntity<ApiResponse> handleEmailAlreadyInUseException(EmailAlreadyInUseException exception) {
    return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(StudentNotFoundException.class)
  public ResponseEntity<ApiResponse> handleStudentNotFoundException(StudentNotFoundException exception) {
    return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(BadStateHandlerException.class)
  public ResponseEntity<ApiResponse> handleBadStateHandler(BadStateHandlerException exception) {
    return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
