package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@Query("SELECT * from Article a WHERE a.auteur.nom LIKE %:nom% AND a.publication = TRUE")
	public List<Article> findArticlesByAuteurNom(@Param("nom") String nom);
	
	@Query("SELECT * from Article a WHERE a.motsCles LIKE %:motsCles% AND a.publication = TRUE")
	public List<Article> findByMotsCles(String motsCles);

}
