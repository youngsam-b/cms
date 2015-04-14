package com.cms.app.util;

import org.springframework.stereotype.Component;


@Component
public class FileUploadResponse {

	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getHiddenpath() {
		return hiddenpath;
	}
	public void setHiddenpath(String hiddenpath) {
		this.hiddenpath = hiddenpath;
	}
	private String imagepath;
	private String hiddenpath;
}
