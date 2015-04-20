package com.cms.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.cms.app.model.Article;
import com.cms.app.model.User;
import com.cms.app.repository.ArticleRepository;
import com.cms.app.repository.UserRepository;

@Service
public class CmsServiceImpl implements CmsService {

	@Autowired
	UserRepository ur;
	
	@Autowired
	ArticleRepository ar;
	
	@Override
	public boolean register(User user) {
		return ur.register(user)>1;		
	}

	@Override
	public User signIn(String email, String pwd) {
		return ur.getUser(email, pwd);
	}

	@Override
	public boolean update(User user) { 
		return ur.update(user)>1;
	}

	@Override
	public boolean isExist(String email) {
		return ur.isExist(email);
	}
	
	@Override
	public boolean activate(String email,String str){
		return ur.activate(email, str);
	}

	@Override
	public User getUserbyEmail(String email) {
		return ur.getUserbyEmail(email);
	}

	@Override
	public User getUserbyId(int id) {
		return ur.getUserbyId(id);
	}

	@Override
	public boolean write(Article article) {
		return ar.write(article)>1;
	}

	@Override
	public boolean update(Article article) {
		return ar.update(article)==1;
	}

	@Override
	public boolean delete(int id) {
			return ar.delete(id)==1;
	}

	@Override
	public Article getArticle(int id) {
		return ar.getArticle(id);
	}

	@Override
	public List<Article> getArticleList(String category, int pageNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
