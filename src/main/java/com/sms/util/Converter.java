package com.sms.util;


import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.sms.entities.Parent;
import com.sms.entities.Student;
import com.sms.entities.Teacher;
import com.sms.model.ParentDTO;
import com.sms.model.StudentDTO;
import com.sms.model.TeacherDTO;
@Component
public class Converter {

//convert from DTO to Entity

public  Student convertToStudentEntity(StudentDTO studentDTO)
{
	Student student=new Student();
	if(studentDTO!=null)
	{
		BeanUtils.copyProperties(studentDTO, student);
	}
     return student;
}

//convert from Entity to DTO
public StudentDTO convertToStudentDTO(Student student)
{
	StudentDTO studentDTO=new StudentDTO();
	if(student!=null)
	{
		BeanUtils.copyProperties(student, studentDTO);
	}
	return studentDTO;
}



//convert from DTO to Entity

public  Teacher convertToTeacherEntity(TeacherDTO teacherDTO)
{
	Teacher teacher=new Teacher();
	if(teacherDTO!=null)
	{
		BeanUtils.copyProperties(teacherDTO, teacher);
	}
     return teacher;
}

//convert from Entity to DTO
public TeacherDTO convertToTeacherDTO(Teacher teacher)
{
	TeacherDTO teacherDTO=new TeacherDTO();
	if(teacher!=null)
	{
		BeanUtils.copyProperties(teacher, teacherDTO);
	}
	return teacherDTO;
}

public Parent convertToParentEntity(ParentDTO parentDTO) {
	// TODO Auto-generated method stub
	Parent prnt=new Parent();
	if(parentDTO!=null)
	{
		BeanUtils.copyProperties(parentDTO, prnt);
	}
     return prnt;
}

//convert from Entity to DTO
public ParentDTO convertToParentDTO(Parent parent)
{
	ParentDTO parentDTO=new ParentDTO();
	if(parent!=null)
	{
		BeanUtils.copyProperties(parent, parentDTO);
	}
	return parentDTO;
}


}
