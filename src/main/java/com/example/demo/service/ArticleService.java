package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Article;
import com.example.demo.entity.Auteur;

public interface ArticleService {
	
	public void addArticle(Auteur auteur, Article article);
	public Article getArticleById(long id);
	public void save(Article article);
	public void delete(Article article);
	public List<Article> getArticlesByAuteurNom(String nom);
	public List<Article> getArticlesByMotsCles(String motsCles);

}
