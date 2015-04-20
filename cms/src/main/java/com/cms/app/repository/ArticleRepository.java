package com.cms.app.repository;

import com.cms.app.model.Article;


public interface ArticleRepository {
	int write(Article article);
	int update(Article article);
	int delete(int id);
	Article getArticle(int id);
	Article getArticleList(String category,int pageNo);
}
