package com.intellizones.gateway.webproject.dto;

import java.util.HashMap;

public class ConnectionConfigDTO extends CommonDTO {

	public ConnectionConfigDTO(){
		fieldIDAndTypeMap	=	new HashMap<String, String>();
	}
	
	private  String connectionId	=	null;
	public String getConnectionId() {
		return connectionId;
	}
	public void setConnectionId(String connectionId) {
		this.connectionId = connectionId;
	}
	public String getConnectionName() {
		return connectionName;
	}
	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}
	public String getRemoteConnType() {
		return remoteConnType;
	}
	public void setRemoteConnType(String remoteConnType) {
		this.remoteConnType = remoteConnType;
	}
	public String getRemoteRESTConnURL() {
		return remoteRESTConnURL;
	}
	public void setRestRemoteConnURL(String remoteRESTConnURL) {
		this.remoteRESTConnURL = remoteRESTConnURL;
	}
	public String getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	public HashMap<String, String> getFieldIDAndTypeMap() {
		return fieldIDAndTypeMap;
	}
	
	public void setFieldIDAndTypeMap(HashMap<String, String> fieldIDAndTypeMap) {
		this.fieldIDAndTypeMap = fieldIDAndTypeMap;
	}
	
	public void addFieldAndDataType(String key,String value){
		this.fieldIDAndTypeMap.put(key, value);
	}
	
	public String getDataType(String fieldName){
		return this.fieldIDAndTypeMap.get(fieldName);
	}

	private  String connectionName						=	null;
	private  String remoteConnType						=	null;
	private  String remoteRESTConnURL					=	null;
	private  String securityKey							=	null;
	private HashMap<String, String>	fieldIDAndTypeMap	=	null;
	
	
}
