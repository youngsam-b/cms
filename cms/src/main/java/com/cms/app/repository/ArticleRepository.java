package com.cms.app.repository;

import java.util.List;
import com.cms.app.model.Article;

public interface ArticleRepository {

	Article find(String entity,int no);
	List<Article> findAll(String entity,int page);
	Long findAllTotalPage(String entity);
	int findMaxGrp(String entity);
	
	List<Article>  findbyCategory(int categoryId,String entity);
	int findbyCategoryTotalPage(int categoryId,String entity);
	List<Article> findbyTitle(String title,String entity) ;
	int findbyTitleTotalPage(int categoryId,String entity);
	List<Article> findbyBody(String Body,String entity);
	int findbyBodyTotalPage(int categoryId,String entity);

	List<Article> findbyEmail(String email,String entity);
	List<Article> findbyName(String name,String entity);
	 
}
