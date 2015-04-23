package com.cms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.cms.web.service.CmsService;


@Controller
public class HomeController {
	@Autowired
	CmsService cs;
	
	@RequestMapping(value = {"/","/index","index.html"}, method = RequestMethod.GET)
	public String home() {		
		return "home";
	}

	@RequestMapping(value = {"/about"}, method = RequestMethod.GET)
	public String about() {		
		return "about";
	}

	/*
    @ExceptionHandler(com.cms.app.exception.CustomException.class)
	public String handleError(HttpServletRequest req, CustomException ex) {
    	
    	
    	logger.warn("======================================================================");
    	logger.warn(req.getRequestURL().toString());
    	try {
    	StringWriter sw = new StringWriter();
    	ex.printStackTrace(new PrintWriter(sw));
    	logger.warn(sw.toString());    	
    	sw.close();
		} catch (IOException e) {		
			e.printStackTrace();
		}
    	logger.warn("======================================================================");
    	
	    return "error";
	  }	
	 */	
}
