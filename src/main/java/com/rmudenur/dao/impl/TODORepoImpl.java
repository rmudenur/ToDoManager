package com.rmudenur.dao.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.rmudenur.dao.TODORepo;
import com.rmudenur.dto.DetailsDTO;

/**
 * @author rmudenur
 *
 */
@Repository
public class TODORepoImpl implements TODORepo {

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<DetailsDTO> getTodoList(String userID) throws Exception {
		
		List<DetailsDTO> lstDetails = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("userID").in(userID));
			lstDetails = (List<DetailsDTO>) mongoTemplate.find(query, DetailsDTO.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstDetails;

	}

	public void addTODO(DetailsDTO objDetailsDTO) throws Exception {

		try {
			objDetailsDTO.setTodoID(UUID.randomUUID().toString());
			mongoTemplate.insert(objDetailsDTO, "tododetails");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateToDo(DetailsDTO objDetailsDTO) throws Exception {

		try {
			Update actUpdate = new Update();
			actUpdate.set("todoName", objDetailsDTO.getTodoName());
			actUpdate.set("description", objDetailsDTO.getDescription());
			actUpdate.set("userID", objDetailsDTO.getUserID());

			// mongoTemplate.updateFirst(new
			// Query(Criteria.where("_id").is(objDetailsDTO.getTodoID())),
			// actUpdate, "tododetails");
			mongoTemplate.save(objDetailsDTO, "tododetails");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deleteToDo(String todoID) throws Exception {
		try {
			mongoTemplate.findAndRemove(new Query(Criteria.where("_id").is(todoID)), DetailsDTO.class, "tododetails");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
