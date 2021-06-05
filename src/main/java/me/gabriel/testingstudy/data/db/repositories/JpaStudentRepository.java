package me.gabriel.testingstudy.data.db.repositories;

import me.gabriel.testingstudy.data.db.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by daohn on 30/05/2021
 * @author daohn
 * @since 30/05/2021
 */
@Repository
public interface JpaStudentRepository extends JpaRepository<StudentEntity, Long> {
  @Query("SELECT " +
         "  CASE " +
         "    WHEN COUNT(student) > 0 THEN true " +
         "    ELSE false " +
         "  END AS isRegistered " +
         "FROM StudentEntity student " +
         "WHERE student.email = :email"
  )
  Boolean isEmailAlreadyInUse(String email);

}
