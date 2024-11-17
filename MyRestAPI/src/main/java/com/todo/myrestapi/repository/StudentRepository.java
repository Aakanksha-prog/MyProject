package com.todo.myrestapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.todo.myrestapi.entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
  
	List<Student>findByFirstName(String firstName);
    Student findByLastNameAndFirstName (String lastName, String firstName);
	
	List<Student> findByFirstNameOrLastName (String firstName, String lastName);
	
	List<Student> findByFirstNameIn (List<String> firstNames);

	List<Student> findByFirstNameContains(String firstName);
	
	List<Student> findByFirstNameStartsWith(String firstName);
	@Query("From Student where firstName = :firstname and lastName = :lastName")
	Student getByLastNameAndFirstName (String lastName, @Param("firstname") String firstName);
	
	@Modifying
	@Transactional
	@Query("Update Student set firstName = :firstName where id = :id")
	Integer updateFirstName (Long id, String firstName);
	
	@Modifying
	@Transactional
	@Query("Delete From Student where firstName = :firstName")
	Integer deleteByFirstName (String firstName);

	
}
  