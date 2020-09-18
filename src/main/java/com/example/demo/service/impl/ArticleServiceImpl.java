package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.ArticleRepository;
import com.example.demo.entity.Article;
import com.example.demo.entity.Auteur;
import com.example.demo.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public void addArticle(Auteur auteur, Article article) {
		articleRepository.save(article);
		auteur.getArticles().add(article);
	}

	@Override
	public Article getArticleById(long id) {
		return articleRepository.getOne(id);
	}

	@Override
	public void save(Article article) {
		articleRepository.save(article);
	}

	@Override
	public void delete(Article article) {
		articleRepository.delete(article);
	}

	@Override
	public List<Article> getArticlesByAuteurNom(String nom) {
		return articleRepository.findArticlesByAuteurNom(nom);
	}

	@Override
	public List<Article> getArticlesByMotsCles(String motsCles) {
		return articleRepository.findByMotsCles(motsCles);
	}

}
