package com.cms.app.repository;

import com.cms.app.model.Article;


public interface ArticleRepository {

	int write(Article article);
	int update(Article article);
	int delete(String category,int no);
	Article getArticle(String category,int id);
}
