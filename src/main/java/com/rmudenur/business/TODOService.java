package com.rmudenur.business;

import java.util.List;
import com.rmudenur.dto.DetailsDTO;

/**
 * @author rmudenur
 *
 */
public interface TODOService {

	public List<DetailsDTO> getTodoList(String userID) throws Exception;

	public void addTODO(DetailsDTO objDetailsDTO) throws Exception;

	public void updateToDo(DetailsDTO objDetailsDTO) throws Exception;

	public void deleteToDo(String todoID) throws Exception;

}
