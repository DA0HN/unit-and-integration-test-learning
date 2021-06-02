package me.gabriel.testingstudy.domain.student;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by daohn on 01/06/2021
 * @author daohn
 * @since 01/06/2021
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
  private String name;
  private String email;
  private String gender;
}
