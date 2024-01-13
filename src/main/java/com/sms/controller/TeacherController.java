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
import com.sms.entities.Teacher;
import com.sms.model.TeacherDTO;
import com.sms.service.TeacherService;
import com.sms.util.Converter;

@RestController
@RequestMapping("/api")
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private Converter converter;
	
	@PostMapping("/createteacher")	
	 ResponseEntity<TeacherDTO> registerTeacher(@RequestBody TeacherDTO teacherDTO)	
	 {
		final Teacher teacher=converter.convertToTeacherEntity(teacherDTO);
		return new ResponseEntity<TeacherDTO>(teacherService.registerTeacher(teacher),HttpStatus.CREATED); 
	 }
	
	@PostMapping("/assignmentstudent/{tid}/{sid}")
	public String assignStudentToTeacher(@PathVariable("tid") int tid,
			@PathVariable("sid") int sid)
	{
		return teacherService.assignStudentToTeacher(tid, sid);
	}


   @GetMapping("/allteacher")  
   List<TeacherDTO> getAllTeacher()
   {
	return teacherService.getAllTeacher();
    }

   @GetMapping("/teacherbyid/{sid}")
	TeacherDTO getTeacherById(@PathVariable("tid") int id)
  {
	   return teacherService.getTeacherById(id);
  }
   @PutMapping("/updateteacher/{id}")
   TeacherDTO	updateTeacher(@Valid @PathVariable int id,@RequestBody TeacherDTO teacherDTO)
{
		final Teacher rent=converter.convertToTeacherEntity(teacherDTO);
	return teacherService.updateTeacher(id, rent);
}

	
	@DeleteMapping("/deleteteacher/{id}")
	String deleteTeacher(@PathVariable int id)
	{
		return teacherService.deleteTeacher(id);
	}




}