package com.sms.service;

import java.util.List;
import com.sms.entities.Teacher;
import com.sms.model.TeacherDTO;

public interface TeacherService {
TeacherDTO	registerTeacher(Teacher teacher);
String assignStudentToTeacher(int tid,int sid);
List<TeacherDTO> getAllTeacher();
TeacherDTO getTeacherById(int id);
TeacherDTO updateTeacher(int id,Teacher teacher);
String deleteTeacher(int id);

}
