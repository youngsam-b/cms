package com.cms.web.service;

import com.cms.app.model.User;


public interface CmsService {
	
	void register(User user);
	User signIn(String email,String pwd);
	boolean update(User u);
	boolean signOut(User u);
	boolean isExist(String email);
	boolean activate(String email,String str);
}
