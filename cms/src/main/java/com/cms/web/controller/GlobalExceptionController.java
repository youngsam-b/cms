package com.cms.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cms.app.exception.CustomException;

@ControllerAdvice
public class GlobalExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
    @ExceptionHandler(com.cms.app.exception.CustomException.class)
	public String handleError(HttpServletRequest req, CustomException cex) {    	
    	    	  	
    	logger.warn("======================================================================");
    	logger.warn(req.getRequestURL().toString());
    	try {
    	StringWriter sw = new StringWriter();
    	cex.getEx().printStackTrace(new PrintWriter(sw));
    	logger.warn(sw.toString());    	
    	sw.close();
		} catch (IOException ioex) {		
			ioex.printStackTrace();
		}
    	logger.warn("======================================================================");
    	
	    return "error";
	  }	

}
