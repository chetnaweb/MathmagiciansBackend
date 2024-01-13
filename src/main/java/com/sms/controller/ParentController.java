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

import com.sms.entities.Parent;
import com.sms.model.ParentDTO;
import com.sms.service.ParentService;
import com.sms.util.Converter;

@RestController
@RequestMapping("/api")
public class ParentController {

	@Autowired
	private ParentService parentService;
	
	@Autowired
	private Converter converter;
	
	
	@PostMapping("/createparent")	
	 ResponseEntity<ParentDTO> createParent(@RequestBody ParentDTO parentDTO)	
	 {
		final Parent parnt=converter.convertToParentEntity(parentDTO);
		return new ResponseEntity<ParentDTO>(parentService.createParent(parnt),HttpStatus.CREATED); 
	 }
	
	@GetMapping("/allparent")
	List<ParentDTO> getAllParent()
	{
		return parentService.getAllParent();
	}
	
	@GetMapping("/parentbyid/{pid}")
	ParentDTO getParentById(@PathVariable("pid") int id)
   {
	   return parentService.getParentById(id);
   }
	
	@PutMapping("/updateparent/{id}")
    ParentDTO	updateParent(@Valid @PathVariable int id,@RequestBody ParentDTO parentDTO)
{
		final Parent parent=converter.convertToParentEntity(parentDTO);
	return parentService.updateParent(id, parent);
}
	@DeleteMapping("/deleteparent/{id}")
	String deleteParent(@PathVariable int id)
	{
		return parentService.deleteParent(id);
	}
}

