package com.sms.entities;

import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Teacher_Id;
	
	@Column(length = 100)
	private String First_name;
	@Column(length = 100)
	private String Last_name;
	@Column(length = 100)
	private String Email_Id;
	@Column(length = 100)
	private String Password;
	@Column(length = 3000)
	private String Your_Query;


	//one teacher can teach many students
	@OneToMany(mappedBy = "teacher",cascade = CascadeType.PERSIST) //teacher id will be foreign key
	@JsonIgnoreProperties("teacher")
	List<Student> students;
     

     }
//teacher_id