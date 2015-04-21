package com.cms.app.repository;

import java.util.List;

import com.cms.app.model.Article;


public interface ArticleRepository {
	int write(Article article);
	int update(Article article);
	int delete(int id);
	Article getArticle(int id);
	List<Article> getArticleList(int userId,int pageNo);
}
