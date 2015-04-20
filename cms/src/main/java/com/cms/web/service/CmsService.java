package com.cms.web.service;

import java.util.List;

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
	
	boolean write(Article article);
	boolean update(Article article);
	boolean delete(int no);
	Article  getArticle(int id);
	List<Article>  getArticleList(String category,int pageNo);
}
