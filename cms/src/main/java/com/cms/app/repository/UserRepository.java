package com.cms.app.repository;

import com.cms.app.model.User;

public interface UserRepository {	
	 int register(User u);
	 boolean update(User u);
	 boolean isExist(String email);
	 User signIn(String email,String pwd);
	 boolean signOut(User u);
	 boolean activate(String email,String str);
	
}
