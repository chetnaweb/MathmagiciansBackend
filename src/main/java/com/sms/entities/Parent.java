package com.sms.entities;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parent {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int Parent_Id;

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


//many student -one teacher
@ManyToOne(cascade = CascadeType.PERSIST)
@JoinColumn(name = "Teacher_Id")
@JsonIgnoreProperties("students")
private Teacher teacher;


}


	