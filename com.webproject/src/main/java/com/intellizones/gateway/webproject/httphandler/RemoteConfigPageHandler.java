package com.intellizones.gateway.webproject.httphandler;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.intellizones.gateway.webproject.datatypes.DataTypes;
import com.intellizones.gateway.webproject.dto.ConnectionConfigDTO;
import com.intellizones.gateway.webproject.util.ApplicationSessionManager;
import com.intellizones.gateway.webproject.util.ApplicationUtil;

public class RemoteConfigPageHandler extends AbstractHttpRequestHandler {

	private String CURRENT_PAGE_TEMPLATE	=	"template_remoteconfig";
	private String TEMPLATE_REMOTECONNDATATYPES	=	"template_remoteconndatatypes";
	
	@Override
	public void handlePageRenderRequest(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		
		setAction(IHttpHandlers.PAGE_REMOTE_SUBMIT);
		setAppMode("");
		setMode("");
		setNextPage(IHttpHandlers.PAGE_LOCAL_RENDER);
		String remoteConnDataTypeOption	=	ApplicationUtil.getTemplate(TEMPLATE_REMOTECONNDATATYPES);
		StringBuffer	remoteConnDataTypeSB	=	new StringBuffer();
		//RemoteConnTypes	remoteConnTypes[]	=	RemoteConnTypes.values();
		 for (DataTypes r : DataTypes.values()) {
			 String value	=	r.toString();
			 String tempValue	=	null;
			 
			 tempValue	=	StringUtils.replace(remoteConnDataTypeOption, IHttpHandlers.DELIMITER_DATATYPENAME, value);
			 tempValue	=	StringUtils.replace(tempValue, IHttpHandlers.DELIMITER_DATATYPEID, value);			    		 
		     System.out.println(tempValue);
		     remoteConnDataTypeSB.append(tempValue);
		 }

		 ApplicationUtil.printDebugMessage(this.getClass().getSimpleName()," OPTIONS : "+remoteConnDataTypeSB.toString());
		 String embeddedChild	=	getEmbeddedchildTemplate();
		 embeddedChild	=	StringUtils.replace(embeddedChild, IHttpHandlers.DELIMITER_REMOTECONDATTYPESLIST, remoteConnDataTypeSB.toString());
		 setEmbeddedchildTemplate(embeddedChild);;
	}

	@Override
	public void handlePageSubmitRequest(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String[]> map = req.getParameterMap();
		ConnectionConfigDTO	connectionConfigDTO	=	new ConnectionConfigDTO();
		ApplicationSessionManager.removeFromSession(req,ApplicationSessionManager.REMOTECONFIGCONN);
		
		String[] fieldNames = null;
		String[] dataTypes = null;
		
		//ApplicationUtil.printDebugMessage(this.getClass().getCanonicalName(),"Subitted");
		for (Entry<String, String[]> entry : map.entrySet()) {
		    String name = entry.getKey();
		    String [] values	=	entry.getValue();
		    
		    if(name.equals("connectionId")){
		    	connectionConfigDTO.setConnectionId(req.getParameter("connectionId"));
		    } else if(name.equals("connectionName")){
		    	connectionConfigDTO.setConnectionName(req.getParameter("connectionName"));
		    } else if(name.equals("remoteConnType")){
		    	connectionConfigDTO.setRemoteConnType(req.getParameter("remoteConnType"));
		    } else if(name.equals("remoteRESTConnURL")){
		    	connectionConfigDTO.setRemoteConnType(req.getParameter("remoteRESTConnURL"));
		    } else if(name.equals("securityKey")){
		    	connectionConfigDTO.setSecurityKey(req.getParameter("securityKey"));
		    	ApplicationUtil.printDebugMessage(this.getClass().getSimpleName(), req.getParameter("securityKey"));
		    } 
		    
		    if(name.equals("fieldNames")){
		    	fieldNames	=	values;
		    } else if(name.equals("dataTypes")){
		    	dataTypes	=	values;
		    }
		    
		    ApplicationUtil.printDebugMessage(this.getClass().getCanonicalName(),name + ": " + Arrays.toString(values));
		}
		
		setFieldValues(connectionConfigDTO,fieldNames,dataTypes);
		ApplicationSessionManager.createNewSession(req, resp);
		ApplicationSessionManager.putInSession(req, ApplicationSessionManager.REMOTECONFIGCONN, connectionConfigDTO);
	}

	@Override
	public void modifyMainPageTemplate(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		String hiddenFiled	=	ApplicationUtil.getTemplate(PAGE_HIDDEN_FIELD);
		setHiddenFieldTemplate(hiddenFiled);
	}

	@Override
	public void modifyEmbeddedChildPageTemplate(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		String embeddedChild	=	ApplicationUtil.getTemplate(CURRENT_PAGE_TEMPLATE);		
		setEmbeddedchildTemplate(embeddedChild);
	}

	@Override
	public void modifyHiddenFieldPageTemplate(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub		
	}

	@Override
	public void intiHandler(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler, String actionId)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateRequest(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	private void setFieldValues(ConnectionConfigDTO connectionConfigDTO,String[] fieldNames,String[] dataTypes){
		if(fieldNames!=null && fieldNames.length>0 && dataTypes!=null && dataTypes.length>0){
			for(int index=0;index<fieldNames.length;index++){
				ApplicationUtil.printDebugMessage(this.getClass().getSimpleName(), fieldNames[index]+": "+dataTypes[index]);
				connectionConfigDTO.addFieldAndDataType(fieldNames[index], dataTypes[index]);
			}
			
		}
	}
}