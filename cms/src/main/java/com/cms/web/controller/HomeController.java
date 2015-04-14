package com.cms.web.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cms.app.exception.CustomException;
import com.cms.web.service.CmsService;


@Controller
public class HomeController {
	@Autowired
	CmsService cs;
	
	@RequestMapping(value = {"/","/index","index.html"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws CustomException {
		
		
		
		try{
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
	
		
		
		}catch(Exception ex){
			/*throw new CustomException((Object)u);*/
			
		}
		
		return "home";
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
