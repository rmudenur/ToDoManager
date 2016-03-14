package com.rmudenur.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmudenur.business.TODOService;
import com.rmudenur.dao.TODORepo;
import com.rmudenur.dto.DetailsDTO;

/**
 * @author rmudenur
 *
 */
@Service
public class TODOServiceImpl implements TODOService {

	@Autowired
	private TODORepo todoRepo;

	public List<DetailsDTO> getTodoList(String userID) throws Exception {
		return todoRepo.getTodoList(userID);
	}

	public void addTODO(DetailsDTO objDetailsDTO) throws Exception {
		todoRepo.addTODO(objDetailsDTO);
	}

	public void updateToDo(DetailsDTO objDetailsDTO) throws Exception {
		todoRepo.updateToDo(objDetailsDTO);
	}

	public void deleteToDo(String todoID) throws Exception {
		todoRepo.deleteToDo(todoID);
	}

}
