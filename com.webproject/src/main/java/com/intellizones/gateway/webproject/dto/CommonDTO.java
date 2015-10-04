package com.intellizones.gateway.webproject.dto;

public class CommonDTO implements ICommonDTO {

	private String primaryKey	=	null;
	public String getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getTenantID() {
		return tenantID;
	}
	public void setTenantID(String tenantID) {
		this.tenantID = tenantID;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	private String tenantID	=	null;
	private String tenantName	=	null;
}
