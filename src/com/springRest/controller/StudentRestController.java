package com.springRest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.customException.StudentNotFoundException;
import com.springRest.beans.Student;
import com.springRest.beans.StudentExceptionResponse;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> studentsList;
	
	@PostConstruct
	public void loadData(){
		studentsList= new ArrayList<Student>();
		studentsList.add(new Student("Rohit","Patel"));
		studentsList.add(new Student("Mohit","Pal"));
		studentsList.add(new Student("Ritu","Patel"));
	}
	
	@GetMapping("/students")
	public List<Student>getAllStudents(){
		return studentsList;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) throws StudentNotFoundException{
		if(studentsList.size()<=studentId || studentId <0){
			throw new StudentNotFoundException("Student Id not found:"+studentId);
		}
		return studentsList.get(studentId);
	}
	
	
}
