package com.cms.app.repository;

import com.cms.app.model.User;

public interface UserRepository {	
	 int register(User u);
	 int update(User u);
	 boolean isExist(String email);
	 User getUser(String email,String pwd);
	 boolean activate(String email,String str);
	 User getUserbyEmail(String email);	
	 User getUserbyId(int id);
}
