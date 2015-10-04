package com.intellizones.gateway.datastoremanager;

import com.intellizones.gateway.webproject.dto.ConnectionConfigDTO;

public interface IDataStoreManager {

	public boolean persistDataObject(ConnectionConfigDTO connectionConfigDTO,String primaryKey);
	
	public ConnectionConfigDTO retrieveDataObject(String primaryKey);
	
}
