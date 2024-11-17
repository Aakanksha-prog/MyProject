package com.todo.myrestapi.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todo.myrestapi.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentResponse {
    

	private long id;
    
	@JsonProperty("first_name")
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String fullName;
	
	
	public StudentResponse(Student student) {
		this.id=student.getId();
		this.firstName=student.getFirstName();
		this.lastName=student.getLastName();
		this.email=student.getEmail();
		this.fullName = student.getFirstName() + " " +
				student.getLastName();
	}
	
}
