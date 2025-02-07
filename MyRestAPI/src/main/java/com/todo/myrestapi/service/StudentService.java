package com.todo.myrestapi.service;

import java.util.List;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.todo.myrestapi.entity.Student;
import com.todo.myrestapi.repository.StudentRepository;
import com.todo.myrestapi.request.CreateStudentRequest;
import com.todo.myrestapi.request.InQueryRequest;
import com.todo.myrestapi.request.UpdateStudentRequest;
import com.todo.myrestapi.response.StudentResponse;

@Service
public class StudentService {
 
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	public Student createStudent (CreateStudentRequest createStudentRequest) 	{
		Student student=new Student(createStudentRequest) ;
		studentRepository.save(student);
		return student;
	}
	public Student updateStudent(UpdateStudentRequest updateStudentRequest) {
	Student student=studentRepository.findById(updateStudentRequest.getId()).get();
	
	if(updateStudentRequest.getFirstName()!=null && !updateStudentRequest.getFirstName().isEmpty()) {
		student.setFirstName(updateStudentRequest.getFirstName());
	}
	student=studentRepository.save(student);
	return student;
	}
	
	public String deleteStudent(long id) {
		
		studentRepository.deleteById(id);
		return "Student has been deleted successfully";
	}
	
	public List<Student> getByFirstname(String firstName){
		
		return studentRepository.findByFirstName(firstName);
	} 
	public Student getByFirstNameAndLastName (String firstName, String lastName) {
		return studentRepository.findByLastNameAndFirstName(lastName, firstName);
	}
	
	public List<Student> getByFirstNameOrLastName (String firstName, String lastName) {
		return studentRepository.findByFirstNameOrLastName(firstName, lastName);
	}
	
	public List<Student> getByFirstNameIn (InQueryRequest inQueryRequest) {
		return studentRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
	}
	public List<Student> getAllStudentsWithPagination (int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
		
		return studentRepository.findAll(pageable).getContent();
	}
	
	public List<Student> getAllStudentsWithSorting () {
		Sort sort = Sort.by(Sort.Direction.ASC, "firstName", "lastName", "email");
		
		return studentRepository.findAll(sort);
	}
	
	public List<Student> like(String firstName) {
		return studentRepository.findByFirstNameContains(firstName);
	}
	
	public List<Student> startsWith(String firstName) {
		return studentRepository.findByFirstNameStartsWith(firstName);
	}
	public Integer updateStudentWithJpql (Long id, String firstName) {
		return studentRepository.updateFirstName(id, firstName);
	}
	
	public Integer deleteStudent (String firstName) {
		return studentRepository.deleteByFirstName(firstName);
	}

}

