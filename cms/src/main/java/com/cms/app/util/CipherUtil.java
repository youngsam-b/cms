package com.cms.app.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;


public class CipherUtil {

	//"Happy Youngsam:)";
	 private static byte[] key = {
         /*0x74, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x65, 0x63, 0x72, 0x65, 0x74, 0x4b, 0x65, 0x79*/           
           0x48, 0x61, 0x70, 0x70, 0x79, 0x20, 0x59, 0x6f, 0x75, 0x6e, 0x67, 0x73, 0x61, 0x6d, 0x3a, 0x29
	 };
	
	private final static String DELIMITER="||";
	
	 public static String Encrypt(String email,String pwd) {
		 String source=email+"DELIMITER"+pwd;
		 String result=null;
		 try
	        {
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	            result = Base64.encodeBase64String(cipher.doFinal(source.getBytes()));
	            
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	        return result;
	 }

	 public static String[] Decrypt(String source)
	 {
		 String[] results=null;
		 String result=null;
		 try
	        {
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	            final SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            result = new String(cipher.doFinal(Base64.decodeBase64(source)));
	            results=result.split("DELIMITER");
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();

	        }
	        return results;	 
	 }
	 
}