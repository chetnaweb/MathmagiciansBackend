package com.sms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.entities.Student;
import com.sms.model.StudentDTO;
import com.sms.service.StudentService;
import com.sms.util.Converter;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private Converter converter;
	
	
	@PostMapping("/createstudent")	
	 ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO)	
	 {
		final Student student=converter.convertToStudentEntity(studentDTO);
		return new ResponseEntity<StudentDTO>(studentService.createStudent(student),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/allstudent")
	List<StudentDTO> getAllStudents()
	{
		return studentService.getAllStudents();
	}
	
	@GetMapping("/studentbyid/{sid}")
	StudentDTO getStudentById(@PathVariable("sid") int id)
   {
	   return studentService.getStudentById(id);
   }
	
	@PutMapping("/updatestudent/{id}")
	StudentDTO	updateStudent(@Valid @PathVariable int id,@RequestBody StudentDTO studentDTO)
{
		final Student student=converter.convertToStudentEntity(studentDTO);
	return studentService.updateStudent(id, student);
}
	@DeleteMapping("/deletestudent/{id}")
	String deleteStudent(@PathVariable int id)
	{
		return studentService.deleteStudent(id);
	}
}
