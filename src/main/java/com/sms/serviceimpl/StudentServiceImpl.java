package com.sms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entities.Student;
import com.sms.exception.ResourceNotFoundException;
import com.sms.model.StudentDTO;
import com.sms.repository.StudentRepository;
import com.sms.service.StudentService;
import com.sms.util.Converter;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public StudentDTO createStudent(Student student) {
		
		Student stud=studentRepository.save(student);
		return converter.convertToStudentDTO(stud);
	}

	@Override
	public List<StudentDTO> getAllStudents() {
		List<Student> students=studentRepository.findAll();
		
		//list of type DTO
		List<StudentDTO> dtoList=new ArrayList<>();
		for(Student s:students)
		{
			dtoList.add(converter.convertToStudentDTO(s));
		}
		
		return dtoList;
	}

	@Override
	public StudentDTO getStudentById(int id) {
		Student s=studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "Id", id));
		return converter.convertToStudentDTO(s);
	}

	@Override
	public StudentDTO updateStudent(int id, Student student) {
		Student s=studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "Id", id));
		s.setFirst_name(student.getFirst_name());
		s.setLast_name(student.getLast_name());
		s.setEmail_Id(student.getEmail_Id());
		s.setPassword(student.getPassword());
		s.setYour_Query(student.getYour_Query());
		
		Student stud=studentRepository.save(s);
		return converter.convertToStudentDTO(stud);
	}

	@Override
	public String deleteStudent(int id) {
		studentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Student", "Id", id));
		
		studentRepository.deleteById(id);
		return "Students got deleted successfully!!";
				
	}

}
