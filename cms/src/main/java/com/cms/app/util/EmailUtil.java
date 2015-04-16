package com.cms.app.util;


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
	
	@Value("${msg.username}")
	private String username;	
	
	@Value("${msg.password}")
	private String password;

	
	
	public void send(String to,String str){
		if(to==null)
			return;
		
		
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		
		sb1.append(to).append("account activation link");
		sb2.append("Dear ").append(to).append("\r\n")
		   .append("Thank you for your registration")
		   .append("To activate your account")
		   .append("Please click below link")
		   .append("http://localhost.com/activate/email=").append(to)
		   .append("&")
		   .append("code=").append(str);
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
								 InternetAddress.parse(to));
			message.setSubject(sb1.toString());
			message.setText(sb2.toString());
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}					
	}
	public void sendPwd(String to,String pwd){
		if(to==null)
			return;
		
		
		StringBuilder sb1=new StringBuilder();
		StringBuilder sb2=new StringBuilder();
		
		sb1.append(to).append("Your password request");
		sb2.append("Dear ").append(to).append("\r\n")
		   .append("Please refer to the below")
		   .append("password : ").append(pwd);
		
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
								 InternetAddress.parse(to));
			message.setSubject(sb1.toString());
			message.setText(sb2.toString());
 
			Transport.send(message);
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}					
	}	
}
