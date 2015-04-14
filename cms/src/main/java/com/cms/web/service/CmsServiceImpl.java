package com.cms.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.app.model.User;
import com.cms.app.repository.UserRepository;

@Service
public class CmsServiceImpl implements CmsService {

	@Autowired
	UserRepository ur;

	@Override
	public void register(User user) {
		ur.register(user);		
	}

	@Override
	public User signIn(String email, String pwd) {
		return ur.signIn(email, pwd);
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean signOut(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExist(String email) {
		// TODO Auto-generated method stub
		return ur.isExist(email);
	}
	
	@Override
	public boolean activate(String email,String str){
		return ur.activate(email, str);
	}
	
	
}
