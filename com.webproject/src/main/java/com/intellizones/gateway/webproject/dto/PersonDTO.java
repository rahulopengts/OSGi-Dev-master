package com.intellizones.gateway.webproject.dto;

public class PersonDTO extends CommonDTO {

	private String firtName	=	null;
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	private String lastName	=	null;
}
