package com.cms.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cms.app.exception.CustomException;
import com.cms.app.util.CommonUtil;
import com.cms.app.util.FileUploadResponse;


@Controller
public class FileUploadController {
		
	
	@Value("${upload.path}")
	private String uploadpath;

	@Autowired
	private FileUploadResponse uploadResponse;
	
	@RequestMapping(value = {"/asyncfileupload"}, method = RequestMethod.POST)
	public 
	@ResponseBody
	FileUploadResponse 
	AsyncUploadFile(HttpServletRequest request,
							@RequestParam("file")MultipartFile multipartFile,
							@RequestParam("subfolder")String subfolder,
							@RequestParam("isSE")Boolean b){
		
	ServletContext servletContext=request.getSession().getServletContext();
	StringBuilder sb= new StringBuilder(servletContext.getRealPath(uploadpath));
	sb.append(File.separator).append(subfolder);
	String icon="";
	try{
	icon=CommonUtil.saveUploadedFile(sb.toString(),multipartFile);
	}catch(IOException ex){
		throw new CustomException(null,ex);
	}
	
	StringBuilder sb2= new StringBuilder();
	String tmp=sb2.append(uploadpath).append(subfolder).append("/").append(icon).toString();
    
	uploadResponse.setHiddenpath(tmp);
    uploadResponse.setImagepath(servletContext.getContextPath()+tmp);
	
	return uploadResponse;
	}	

	@RequestMapping(value = {"/uploadfile"}, method = RequestMethod.POST)
	public ModelAndView  
	UploadFile(HttpServletRequest request,
							@RequestParam("file")MultipartFile multipartFile,
							@RequestParam("subfolder")String subfolder,
							@RequestParam("isSE")Boolean b							
							) {
		
	ServletContext servletContext=request.getSession().getServletContext();	
	String path=servletContext.getRealPath(uploadpath);	
	path+=File.separator+subfolder;
	String icon;
	try {
		icon = CommonUtil.saveUploadedFile(path,multipartFile);
	} catch (IOException ex) {
		// TODO Auto-generated catch block
		throw new CustomException(null,ex);
	}
    uploadResponse.setHiddenpath(uploadpath+"/"+subfolder+"/"+icon);
    uploadResponse.setImagepath(servletContext.getContextPath()+uploadpath+"/"+subfolder+"/"+icon);	   	

	ModelMap model = new ModelMap();	
	
    if(b){
    	String callback_func=((MultipartHttpServletRequest)request).getParameter("callback_func");
    	StringBuilder sb= new StringBuilder();
    	sb.append(request.getScheme()).append("://")
    	  .append(request.getServerName().toString()).append(":")
    	  .append(request.getServerPort()).append("/")
    	  .append(request.getContextPath()+"/resources/se2/photo_uploader/popup/callback.html?")
    	  .append("callback_func=").append(callback_func)
    	  .append("&bNewLine=").append(true)
    	  .append("&sFileName=").append(icon)
    	  .append("&sFileURL=").append(uploadResponse.getImagepath());
    	
    	return new ModelAndView("redirect:"+sb.toString());    	
	    }
	    else{
	    model.put("uploadResponse", uploadResponse);
	    String returnUrl = CommonUtil.redirectProcess(request.getHeader("referer"));
	    
		return new ModelAndView(returnUrl);
		}	
	}
}
