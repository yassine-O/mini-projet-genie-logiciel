package com.example.demo.service;

import com.example.demo.entity.Article;
import com.example.demo.entity.Auteur;
import com.example.demo.entity.Evaluation;
import com.example.demo.entity.Evaluation_PK;

public interface EvaluationService {
	
	public void affectation(Article article, Auteur referee);
	public Evaluation getEvaluationById(Evaluation_PK pk);
	public void save(Evaluation evaluation);

}
