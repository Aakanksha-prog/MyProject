package com.todo.myrestapi.controller;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todo.myrestapi.entity.Student;
import com.todo.myrestapi.repository.StudentRepository;
import com.todo.myrestapi.request.CreateStudentRequest;
import com.todo.myrestapi.request.InQueryRequest;
import com.todo.myrestapi.request.UpdateStudentRequest;
import com.todo.myrestapi.response.StudentResponse;
import com.todo.myrestapi.service.StudentService;

import jakarta.validation.Valid;


@RestController
@Validated
@RequestMapping("/api/student/")

public class StudentController {
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentService studentService;
	
	@GetMapping("getAll")
	public List<StudentResponse> getAllStudents() {
		
		logger.error("Inside Error");
		logger.warn("Inside Warning");
		logger.info("Inside Info");
		logger.debug("Inside Debug");
		logger.trace("Inside Trace");

		List<Student> studentList= studentService.getAllStudents();
		List<StudentResponse> studentResponsesList=new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponsesList.add(new StudentResponse(student));
		});
		return studentResponsesList;
	}
	
	@PostMapping("create")  //@RequestBody  will convert Json into our modal class 
	public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
		Student student=studentService.createStudent(createStudentRequest);
		return new StudentResponse(student);
	}
	@PutMapping("update")
	public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
		Student student=studentService.updateStudent(updateStudentRequest);
				return new StudentResponse(student);
	}
	/*@DeleteMapping("delete")
	public String deleteStudent(@RequestParam long id) {
		return studentService.deleteStudent(id);
	}*/
	@DeleteMapping("delete/{id}")
	public String deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
}
    @GetMapping("getByFirstName/{firstName}")
    	public List<StudentResponse> getByFirstName(@PathVariable String firstName){
    	List<Student> studentList =studentService.getByFirstname(firstName);
    	List<StudentResponse> studentResponsesList=new ArrayList<StudentResponse>();
		studentList.stream().forEach(student ->{
			studentResponsesList.add(new StudentResponse(student));
		});
		return studentResponsesList;
    	}
    @GetMapping("getByFirstNameAndLastName/{firstName}/{lastName}")
	public StudentResponse getByFirstNameAndLastName (@PathVariable String firstName, 
			@PathVariable String lastName) {
		return new StudentResponse(studentService.getByFirstNameAndLastName(firstName, lastName));
	}
	
	@GetMapping("getByFirstNameOrLastName/{firstName}/{lastName}")
	public List<StudentResponse> getByFirstNameOrLastName (@PathVariable String firstName, 
			@PathVariable String lastName) {
		List<Student> studentList = studentService.getByFirstNameOrLastName(firstName, lastName);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("getByFirstNameIn")
	public List<StudentResponse> getByFirstNameIn (
			@RequestBody InQueryRequest inQueryRequest) {
		
		//logger.info("inQueryRequest=" + inQueryRequest);
      List<Student> studentList = studentService.getByFirstNameIn(inQueryRequest);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		logger.info("studentResponseList=" + studentResponseList);
		return studentResponseList;
	}
           
	@GetMapping("getAllWithPagination")
	public List<StudentResponse> getAllStudentsWithPagination (@RequestParam int pageNo,
			@RequestParam int pageSize) {
		
		List<Student> studentList = studentService.
				getAllStudentsWithPagination(pageNo, pageSize);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	@GetMapping("getAllWithSorting")
	public List<StudentResponse> getAllStudentsWithSorting () {
		
		List<Student> studentList = studentService.getAllStudentsWithSorting();
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("like/{firstName}")
	public List<StudentResponse> like(@PathVariable String firstName) {
		
		List<Student> studentList = studentService.like(firstName);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	
	@GetMapping("startsWith/{firstName}")
	public List<StudentResponse> startsWith(@PathVariable String firstName) {
		
		List<Student> studentList = studentService.startsWith(firstName);
		
		List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponseList.add(new StudentResponse(student));
		});
		
		return studentResponseList;
	}
	@PutMapping("updateFirstName/{id}/{firstName}")
	public String updateStudentWithJpql (@PathVariable Long id, @PathVariable String firstName) {
		return studentService.updateStudentWithJpql(id, firstName)+ " Student(s) updated";
	}
	
	@DeleteMapping("deleteByFirstName/{firstName}")
	public String deleteStudent (@PathVariable String firstName) {
		return studentService.deleteStudent(firstName) + " Student(s) deleted";
	}
    	}	

