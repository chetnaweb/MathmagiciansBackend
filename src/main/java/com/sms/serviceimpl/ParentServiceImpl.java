package com.sms.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.entities.Parent;
import com.sms.exception.ResourceNotFoundException;
import com.sms.model.ParentDTO;
import com.sms.repository.ParentRepository;
import com.sms.service.ParentService;
import com.sms.util.Converter;

@Service
public class ParentServiceImpl implements ParentService{

	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private Converter converter;
	
	@Override
	public ParentDTO createParent(Parent parent) {
		
		Parent prt=parentRepository.save(parent);
		return converter.convertToParentDTO(prt);
	}

	@Override
	public List<ParentDTO> getAllParent() {
		List<Parent> prt=parentRepository.findAll();
		
		//list of type DTO
		List<ParentDTO> dtoList=new ArrayList<>();
		for(Parent s:prt)
		{
			dtoList.add(converter.convertToParentDTO(s));
		}
		
		return dtoList;
	}

	@Override
	public ParentDTO getParentById(int id) {
		Parent s=parentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Parent", "Id", id));
		return converter.convertToParentDTO(s);
	}

	@Override
	public ParentDTO updateParent(int id, Parent parent) {
		Parent s=parentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Parent", "Id", id));
		s.setFirst_name(parent.getFirst_name());
		s.setLast_name(parent.getLast_name());
		s.setEmail_Id(parent.getEmail_Id());
		s.setPassword(parent.getPassword());
		s.setYour_Query(parent.getYour_Query());
		
		Parent prt=parentRepository.save(s);
		return converter.convertToParentDTO(prt);
	}

	@Override
	public String deleteParent(int id) {
		parentRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Parent", "Id", id));
		
		parentRepository.deleteById(id);
		return "Parent details got deleted successfully!!";
				
	}


}
