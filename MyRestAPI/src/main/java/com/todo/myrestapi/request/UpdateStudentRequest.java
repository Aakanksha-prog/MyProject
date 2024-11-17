package com.todo.myrestapi.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateStudentRequest {
    
	@NotNull(message = "Student Id is required")
	private long id;
    
	private String firstName;
	
	private String lastName;
	
	private String email;
	
}
