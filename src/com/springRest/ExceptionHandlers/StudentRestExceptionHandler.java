package com.springRest.ExceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.springRest.beans.StudentExceptionResponse;
import com.springRest.customException.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandler {

	//to handle studen not found exceptiom
		@ExceptionHandler
		public ResponseEntity<StudentExceptionResponse> handleStudentException(StudentNotFoundException exc){
			StudentExceptionResponse response= new StudentExceptionResponse();
			response.setStatus(HttpStatus.NOT_FOUND.value());
			response.setMessage(exc.getMessage());
			//response.setTimestamp(System.currentTimeMillis());	
			
			return new ResponseEntity<StudentExceptionResponse>(response, HttpStatus.NOT_FOUND);
			
		}
		
		//to handle exception related to bad request
			@ExceptionHandler
			public ResponseEntity<StudentExceptionResponse> handleAllException(Exception exc){
				StudentExceptionResponse response= new StudentExceptionResponse();
				response.setStatus(HttpStatus.BAD_REQUEST.value());
				response.setMessage(exc.getMessage());
				response.setTimestamp(System.currentTimeMillis());	
				
				return new ResponseEntity<StudentExceptionResponse>(response, HttpStatus.BAD_REQUEST);
				
			}
	
}
