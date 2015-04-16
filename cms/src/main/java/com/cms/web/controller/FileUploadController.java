package com.cms.web.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cms.app.exception.CustomException;
import com.cms.app.util.CommonUtil;
import com.cms.app.util.FileUploadResponse;


@Controller
public class FileUploadController {
		
	
	@Value("${upload.path}")
	private String uploadpath;
	@Value("${upload.iconpath}")
	private String iconpath;
	@Value("${upload.imagepath}")
	private String imagepath;

	@Autowired
	private FileUploadResponse uploadResponse;
	
	@RequestMapping(value = {"/iconupload"}, method = RequestMethod.POST)
	public 
	@ResponseBody
	FileUploadResponse 
	AsyncUploadFile(HttpServletRequest request,
					@RequestParam("file")MultipartFile multipartFile
					){
		
	ServletContext servletContext=request.getSession().getServletContext();
	StringBuilder sb= new StringBuilder(servletContext.getRealPath(uploadpath));
	sb.append(File.separator).append(iconpath);
	String icon="";
	try{
	icon=CommonUtil.saveUploadedFile(sb.toString(),multipartFile,true);
	}catch(IOException ex){
		throw new CustomException(null,ex);
	}
	
	StringBuilder sb2= new StringBuilder();
	String tmp=sb2.append(uploadpath).append(iconpath).append("/").append(icon).toString();
    
	uploadResponse.setHiddenpath(tmp);
    uploadResponse.setImagepath(servletContext.getContextPath()+tmp);
	
	return uploadResponse;
	}	

		
	@RequestMapping(value = {"/imageupload"}, method = RequestMethod.POST)
	public 
	@ResponseBody
	String 
	UploadImage(HttpServletRequest request,
			    @RequestParam("CKEditorFuncNum") String CKEditorFuncNum,
			    @RequestParam("CKEditor") String CKEditor,
			    @RequestParam(value="upload")MultipartFile multipartFile
			    ){
			
		ServletContext servletContext=request.getSession().getServletContext();
		StringBuilder sb= new StringBuilder(servletContext.getRealPath(uploadpath));
		sb.append(File.separator).append(imagepath);
		String image="";
		try{
		image=CommonUtil.saveUploadedFile(sb.toString(),multipartFile,false);
		}catch(IOException ex){
			throw new CustomException(null,ex);
		}

		StringBuilder sb2=new StringBuilder();
		
		sb2.append("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(")
		   .append("'").append(CKEditorFuncNum).append("'").append(",")
		   .append("'").append(uploadpath).append(imagepath).append("/").append(image).append("')")
		   .append("</script>");
		   
	
		return sb2.toString();
	
	}
}
