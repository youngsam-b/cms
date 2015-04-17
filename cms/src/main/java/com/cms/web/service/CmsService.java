package com.cms.web.service;

import com.cms.app.model.Article;
import com.cms.app.model.User;


public interface CmsService {
	
	boolean register(User user);
	User signIn(String email,String pwd);
	boolean update(User user);
	boolean isExist(String email);
	boolean activate(String email,String str);
	User getUserbyEmail(String email);
	User getUserbyId(int id);
	
	boolean write(String category,Article article);
	boolean update(String category,Article article);
	boolean delete(String category,int no);
	Article  getArticle(String category,int id);
}
