package com.intellizones.gateway.webproject.httphandler;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intellizones.gateway.webproject.util.ApplicationUtil;

public class RemoteConfigPageHandler extends AbstractHttpRequestHandler {

	private String CURRENT_PAGE_TEMPLATE	=	"template_remoteconfig";
	
	@Override
	public void handlePageRenderRequest(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		
		setAction(IHttpHandlers.PAGE_REMOTE_SUBMIT);
		setAppMode("");
		setMode("");
		setNextPage(IHttpHandlers.PAGE_LOCAL_RENDER);
		
		
//		String embeddedChild	=	ApplicationUtil.getTemplate(CURRENT_PAGE_TEMPLATE);
//		String mainPageTemplate	=	getMainPageTemplate();
//		
//		mainPageTemplate	=	StringUtils.replace(mainPageTemplate, "%embedchild%", embeddedChild);
//		
//		
//		//mainPageTemplate.replaceAll("%embedchild%", embeddedChild);
//		ApplicationUtil.printDebugMessage(this.toString(), mainPageTemplate);
//		ApplicationUtil.printDebugMessage(this.toString(), embeddedChild);
//		
//		writeHttpResponse(req, resp, mainPageTemplate, actionId);
		//StringUtils.replace(text, searchString, replacement)
	}

	@Override
	public void handlePageSubmitRequest(HttpServletRequest req, HttpServletResponse resp, IHttpHandlers handler,
			String actionId) throws Exception {
		// TODO Auto-generated method stub
		Map<String, String[]> map = req.getParameterMap();
		//ApplicationUtil.printDebugMessage(this.getClass().getCanonicalName(),"Subitted");
		for (Entry<String, String[]> entry : map.entrySet()) {
		    String name = entry.getKey();
		    String[] values = entry.getValue();
		    ApplicationUtil.printDebugMessage(this.getClass().getCanonicalName(),name + ": " + Arrays.toString(values));
		}
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
}