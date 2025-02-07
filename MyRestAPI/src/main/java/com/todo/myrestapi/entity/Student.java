package com.todo.myrestapi.entity;


import com.todo.myrestapi.request.CreateStudentRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="student")

public class Student {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;
    
    @Column(name="first_name")
	private String firstName;
	
    @Column(name="last_name")
	private String lastName;
	
    @Column(name="email")
	private String email;
    
    @Transient
	private String fullName;
    
    public Student (CreateStudentRequest createStudentRequest) {
    	this.firstName=createStudentRequest.getFirstName();
    	this.lastName=createStudentRequest.getLastName();
    	this.email=createStudentRequest.getEmail();
    	this.fullName = createStudentRequest.getFirstName() + " " +
				createStudentRequest.getLastName();
    }
    
	
}
