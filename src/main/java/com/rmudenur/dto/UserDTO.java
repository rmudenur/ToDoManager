package com.rmudenur.dto;

import java.util.List;

/**
 * @author rmudenur
 *
 */
public class UserDTO {
	// @Id
	private String userID;
	private String userName;

	private List<DetailsDTO> lstDetailsDTO;

	public List<DetailsDTO> getLstDetailsDTO() {
		return lstDetailsDTO;
	}

	public void setLstDetailsDTO(List<DetailsDTO> lstDetailsDTO) {
		this.lstDetailsDTO = lstDetailsDTO;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

}
