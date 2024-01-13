package com.sms.service;

import java.util.List;
import com.sms.entities.Parent;
import com.sms.model.ParentDTO;

public interface ParentService 
{
	ParentDTO createParent(Parent parent);
	List<ParentDTO> getAllParent();
	ParentDTO getParentById(int id);
	ParentDTO updateParent(int id,Parent parent);
	String deleteParent(int id);

}
