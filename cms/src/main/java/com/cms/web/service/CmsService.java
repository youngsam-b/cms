package com.cms.web.service;

import com.cms.app.model.User;


public interface CmsService {
	
	void register(User user);
	User signIn(String email,String pwd);
	boolean update(User user);
	boolean isExist(String email);
	boolean activate(String email,String str);
	User getUserbyEmail(String email);
	User getUserbyId(int id);
}
