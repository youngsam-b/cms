package com.cms.app.util;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.cms.app.exception.CustomException;


public class ImageUtil {
	
	 public static final int iconMaxWidth=150;
	 public static final int articleMaxWidth=600;
	
	 
	 public static BufferedImage resizeImageWithHint(BufferedImage originalImage, int maxwidth,int newHeight){
		 
			BufferedImage resizedImage = new BufferedImage(maxwidth,newHeight,originalImage.getType());
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(originalImage, 0, 0, maxwidth,newHeight, null);
			g.dispose();	
			g.setComposite(AlphaComposite.Src);
		 
			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
			RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g.setRenderingHint(RenderingHints.KEY_RENDERING,
			RenderingHints.VALUE_RENDER_QUALITY);
			g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
		 
			return resizedImage;
		    }	
	 
	 public static void checkImageWidth(String path,boolean isIcon){
		 try {
			BufferedImage originalImage = ImageIO.read(new File(path));
			int width=originalImage.getWidth();			
			int height=originalImage.getHeight();
			int MaxWidth=articleMaxWidth;
			
			if(isIcon)
				MaxWidth=iconMaxWidth;
				
			if(width>MaxWidth){
				int newHeight=((height*MaxWidth)/width);
				BufferedImage bi=resizeImageWithHint(originalImage, MaxWidth, newHeight);
				ImageIO.write(bi,FilenameUtils.getExtension(path), new File(path));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	 public static boolean isImageContent(MultipartFile multipartFile) {
		   try (InputStream input = multipartFile.getInputStream()) {
			    try {
			   return ImageIO.read(input)!=null;
			    } catch (Exception ex) {
			    	return false;
			    }
		   } catch (IOException ex) {

			   throw new CustomException(ex,null);
	    	}		 
		   
	 }
}