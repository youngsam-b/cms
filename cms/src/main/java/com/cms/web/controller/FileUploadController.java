package com.cms.web.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cms.app.exception.CustomException;
import com.cms.app.util.CommonUtil;
import com.cms.app.util.FileUploadResponse;
import com.cms.app.util.ImageUtil;


@Controller
public class FileUploadController {
		
	
	@Value("${upload.path}")
	private String uploadpath;
	@Value("${upload.iconpath}")
	private String iconpath;
	@Value("${upload.sizelimit}")
	private long sizelimit;

	@Autowired
	private FileUploadResponse uploadResponse;
	
	@RequestMapping(value = {"/iconupload"}, method = RequestMethod.POST)
	public 
	@ResponseBody
	FileUploadResponse 
	AsyncUploadFile(HttpServletRequest request,
					@RequestParam("file")MultipartFile multipartFile
					){
	if(multipartFile.getSize()>sizelimit)
	  		return null;
		   
	if(!ImageUtil.isImageContent(multipartFile))
		   return null;
		
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

		
	@RequestMapping(value = {"/{category}/imageupload"}, method = RequestMethod.POST)
	public 
	@ResponseBody
	String 
	UploadImage(HttpServletRequest request,
				@PathVariable String category,
			    @RequestParam("CKEditorFuncNum") String CKEditorFuncNum,
			    @RequestParam("CKEditor") String CKEditor,
			    @RequestParam(value="upload")MultipartFile multipartFile
			    ){
		
		
	   if(multipartFile.getSize()>sizelimit)
	   		
		   return "<script>window.parent.CKEDITOR.tools.callFunction(0,null,'fize size limit 1MB')</script>";
	   
	   if(!ImageUtil.isImageContent(multipartFile))
		   return "<script>window.parent.CKEDITOR.tools.callFunction(0,null,'this is not a image type file')</script>";
	   
		ServletContext servletContext=request.getSession().getServletContext();
		StringBuilder sb= new StringBuilder(servletContext.getRealPath(uploadpath));
		sb.append(File.separator).append(category);
		String image="";
		try{
		image=CommonUtil.saveUploadedFile(sb.toString(),multipartFile,false);
		}catch(IOException ex){
			throw new CustomException(null,ex);
		}

		StringBuilder sb2=new StringBuilder();
		
		sb2.append("<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(")
		   .append("'").append(CKEditorFuncNum).append("'").append(",")
		   .append("'").append(uploadpath).append(category).append("/").append(image).append("')")
		   .append("</script>");
		   
	
		return sb2.toString();
	
	}
}
