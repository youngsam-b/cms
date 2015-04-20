package com.cms.app.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cms.app.model.User;


public class CommonUtil {

	private final static String COOKIE_NAME="snsBridge";
	
	public static String redirectProcess(String referer){		
		URL url=null;
		try {
			url = new URL(referer);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}		

		return "redirect:"+url.getPath();
	}

	public static String saveUploadedFile(String path,MultipartFile multipartFile,boolean isIcon) throws IOException {
	
	File file=null;
	OutputStream outputStream=null;
	InputStream inputStream=null;	
	byte[] bytes ;
	
	
	inputStream = multipartFile.getInputStream();  
	StringBuilder sb= new StringBuilder();
	sb.append(path) 
	  .append(File.separator)
	  .append(RandomStringUtils.randomAlphanumeric(30))
	  .append(".")
	  .append(FilenameUtils.getExtension(multipartFile.getOriginalFilename()));
			  
	file = new File(
			        sb.toString()
				   	);
		   	
	String str=file.getParent();
	File dir=new File(str);
	if(!dir.exists())
		dir.mkdir();
   
   if (!file.exists())  {	   	
	    file.createNewFile();
   }
	
   	outputStream = new FileOutputStream(file);  
	int read = 0;  
	bytes = new byte[1024];  
		  
	while ((read = inputStream.read(bytes)) != -1) {  
		outputStream.write(bytes, 0, read);  
	}
		   
	outputStream.close();
	inputStream.close();		   
	/*	  	
    ImageUtil.checkImageWidth(
    						  path+
    						  File.separator+
    						  file.getName(),
    						  true
    						  );
    */						  
	return file.getName();
    }
	
	 public static void setRemeberMeCookie(HttpServletRequest request,HttpServletResponse response,User user) {
		 String encrypted=CipherUtil.Encrypt(user.getEmail(),user.getPwd());
		 Cookie c = new Cookie(COOKIE_NAME, encrypted);
		 c.setMaxAge(60*60*24*60); // 60 days
		 response.addCookie(c);			
	 }
	 
	 public static String[] getRememberMeCookie(HttpServletRequest request) {
		 
		 Cookie[] cookies = request.getCookies();
		 String encryptedMessage=null;
		 for (int i = 0; i < cookies.length; i++) {
			 Cookie c = cookies[i];            
			 if (c.getName().equals(COOKIE_NAME)) {
				 encryptedMessage=c.getValue();
				 break;
			 }
		 }     
		 return CipherUtil.Decrypt(encryptedMessage);		 
	 }	 
	 
	 public static void DeleteCookie(HttpServletRequest request,HttpServletResponse response){
		 Cookie[] cookies = request.getCookies();
		 for (int i = 0; i < cookies.length; i++) {
			 Cookie c = cookies[i];            
			 if (c.getName().equals(COOKIE_NAME)) {
				 c.setPath("/");
				 c.setMaxAge(0);
				 response.addCookie(c);
				 break;
			 }
		 }     		 		 
	 }
	 
	 public static void updateSession(HttpSession session,String attr,Object o){
		 if(session.getAttribute(attr)==null)
			 return;
		 
		 session.invalidate();
		 session.setAttribute(attr, o);
	 }
	 
	 public static String getRemoteAddr(HttpServletRequest request){
		 String ipAddress = request.getHeader("X-FORWARDED-FOR");  
		 return ipAddress==null?request.getRemoteAddr():ipAddress;
	 }
	 
	
}