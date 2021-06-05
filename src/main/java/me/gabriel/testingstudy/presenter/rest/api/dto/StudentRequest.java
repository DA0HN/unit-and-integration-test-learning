package me.gabriel.testingstudy.presenter.rest.api.dto;

import lombok.Value;

/**
 * Created by daohn on 05/06/2021
 * @author daohn
 * @since 05/06/2021
 */
@Value
public class StudentRequest {
  String name;
  String email;
  String gender;
}
