package com.rmudenur.dto;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

/**
 * @author rmudenur
 *
 */
@Document(collection = "tododetails")
public class DetailsDTO {
	@Id
	private String todoID;

	private String todoName;

	private String userID;

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getTodoID() {
		return todoID;
	}

	public void setTodoID(String todoID) {
		this.todoID = todoID;
	}

	public String getTodoName() {
		return todoName;
	}

	public void setTodoName(String todoName) {
		this.todoName = todoName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;
}
