package com.sms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entities.Student;
import com.sms.entities.Teacher;
import com.sms.exception.ResourceNotFoundException;
import com.sms.model.TeacherDTO;
import com.sms.repository.StudentRepository;
import com.sms.repository.TeacherRepository;
import com.sms.service.TeacherService;
import com.sms.util.Converter;

@Service
public class TeacherServiceImpl implements TeacherService{


	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public TeacherDTO registerTeacher(Teacher teacher) {
	
		return converter.convertToTeacherDTO(teacherRepository.save(teacher));
	}

	@Override
	public String assignStudentToTeacher(int tid, int sid) {
		Student s=studentRepository.findById(sid).orElseThrow(()->
		new ResourceNotFoundException("Student", "Id", sid));
		
		Teacher  t=teacherRepository.findById(tid).orElseThrow(()->
		new ResourceNotFoundException("Teacher", "Id", tid));
		
		List<Student> students=new ArrayList<>();
		students.add(s);
		
		//assign students to teacher
		t.setStudents(students);
		
		//assign teacher to student
		s.setTeacher(t);
		
		teacherRepository.save(t);
		return "Students assigned to teacher successfully";
	}

	
	@Override
	public List<TeacherDTO> getAllTeacher() {
		List<Teacher> techer=teacherRepository.findAll();
		
		//list of type DTO
		List<TeacherDTO> dtoList=new ArrayList<>();
		for(Teacher s:techer)
		{
			dtoList.add(converter.convertToTeacherDTO(s));
		}
		
		return dtoList;
	}

	@Override
	public TeacherDTO getTeacherById(int id) {
		Teacher s=teacherRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Teacher", "Id", id));
		return converter.convertToTeacherDTO(s);
	}

	@Override
	public TeacherDTO updateTeacher(int id, Teacher teacher) {
		Teacher s=teacherRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Teacher", "Id", id));
		s.setFirst_name(teacher.getFirst_name());
		s.setLast_name(teacher.getLast_name());
		s.setEmail_Id(teacher.getEmail_Id());
		s.setPassword(teacher.getPassword());
		s.setYour_Query(teacher.getYour_Query());
		
		Teacher tcher=teacherRepository.save(s);
		return converter.convertToTeacherDTO(tcher);
	}

	@Override
	public String deleteTeacher(int id) {
		teacherRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Teacher", "Id", id));
		
		teacherRepository.deleteById(id);
		return "Teacher deleted successfully!!";
				
	}

	
	

}
