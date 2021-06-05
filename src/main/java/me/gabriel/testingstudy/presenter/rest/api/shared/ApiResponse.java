package me.gabriel.testingstudy.presenter.rest.api.shared;

import lombok.Value;
import org.springframework.http.ResponseEntity;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@Value
public class ApiResponse {
  Boolean success;
  String message;

  public static ResponseEntity<ApiResponse> map(boolean success, String message) {
    return ResponseEntity.ok(new ApiResponse(success,message));
  }
}
