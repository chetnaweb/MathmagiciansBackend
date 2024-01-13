package com.sms.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.sms.entities.Teacher;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ParentDTO {
	
	@NotNull
	private int Parent_Id;
	
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String First_name;
	
	@NotNull
	@Size(min=3,max=50,message = "Name should have min 2 to max 50 characters")
	private String Last_name;
	
	@NotNull
	private String Email_Id;
	
	@NotNull
	@Size(min=8,max=12,message = "password should contain numbers ,upper and lower characters")
	private String Password;
	
	@NotNull
	@Size(min=5,max=100,message = "Name should have min 2 to max 50 characters")
    private String Your_Query;

	private Teacher teacher;

}

