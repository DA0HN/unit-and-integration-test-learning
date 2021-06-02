package me.gabriel.testingstudy.domain.student;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "student")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Column(nullable = false)
  private String name;

  @Email
  @Column(nullable = false, unique = true)
  private String email;

  @Enumerated(EnumType.STRING)
  @NotNull
  @Column(nullable = false)
  private Gender gender;

  public Student(String name, String email, Gender gender) {
    this.name = name;
    this.email = email;
    this.gender = gender;
  }

  @Override public boolean equals(Object o) {
    if(this == o) return true;
    if(o == null || getClass() != o.getClass()) return false;
    var student = (Student) o;
    return id.equals(student.id);
  }

  @Override public int hashCode() {
    return Objects.hash(id);
  }
}
