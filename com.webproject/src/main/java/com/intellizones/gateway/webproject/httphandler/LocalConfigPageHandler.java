package com.intellizones.gateway.webproject.httphandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.intellizones.gateway.webproject.datatypes.DataTypes;
import com.intellizones.gateway.webproject.util.ApplicationUtil;

public class LocalConfigPageHandler extends AbstractHttpRequestHandler {

	private String CURRENT_PAGE_TEMPLATE	=	"template_localconfig";	
	private String TEMPLATE_FIELDDATATYPES	=	"template_fielddatatypes";
	
	@Override
	public void handlePageRenderRequest(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
//		String embeddedChild	=	ApplicationUtil.getTemplate(CURRENT_PAGE_TEMPLATE);
//		String mainPageTemplate	=	getMainPageTemplate();
//		
//		mainPageTemplate	=	StringUtils.replace(mainPageTemplate, "%embedchild%", embeddedChild);
		
		ApplicationUtil.printDebugMessage(this.getClass().getName(), "In RenderRequest for LocalConfig");
		setAction(IHttpHandlers.PAGE_REMOTE_SUBMIT);
		setAppMode("");
		setMode("");
		setNextPage(IHttpHandlers.PAGE_LOCAL_RENDER);

		populateRemoteFieldDataList();
		//mainPageTemplate.replaceAll("%embedchild%", embeddedChild);
//		ApplicationUtil.printDebugMessage(this.toString(), mainPageTemplate);
//		ApplicationUtil.printDebugMessage(this.toString(), embeddedChild);
//		
//		writeHttpResponse(req, resp, mainPageTemplate, actionId);
		
		
	}

	@Override
	public void handlePageSubmitRequest(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		
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
//		String hiddenFiled	=	ApplicationUtil.getTemplate(PAGE_HIDDEN_FIELD);
//		setHiddenFieldTemplate(hiddenFiled);
		
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

	private void populateRemoteFieldDataList(){
		String remoteConnDataTypeOption	=	ApplicationUtil.getTemplate(TEMPLATE_FIELDDATATYPES);
		StringBuffer	remoteConnDataTypeSB	=	new StringBuffer();
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
		 embeddedChild	=	StringUtils.replace(embeddedChild, IHttpHandlers.DELIMITER_REMOTEFIELDDATALIST, remoteConnDataTypeSB.toString());
		 setEmbeddedchildTemplate(embeddedChild);;
		
	}



}
