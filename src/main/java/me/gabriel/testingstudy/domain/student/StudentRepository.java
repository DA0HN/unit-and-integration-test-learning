package me.gabriel.testingstudy.domain.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query("""
             SELECT
                  CASE
                      WHEN COUNT(student) > 0 THEN true
                      ELSE false
                  END AS isRegistered
             FROM Student student
             WHERE student.email = :email
         """)
  Boolean isEmailAlreadyRegistered(String email);

}
