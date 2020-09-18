package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EvaluationRepository;
import com.example.demo.entity.Article;
import com.example.demo.entity.Auteur;
import com.example.demo.entity.Evaluation;
import com.example.demo.entity.Evaluation_PK;
import com.example.demo.service.EvaluationService;

@Service
@Transactional
public class EvaluationServiceImpl implements EvaluationService {
	
	@Autowired
	private EvaluationRepository evaluationRepository;

	@Override
	public void affectation(Article article, Auteur referee) {
		Evaluation evaluation = new Evaluation(article.getManuscrit(), referee);
		evaluationRepository.save(evaluation);
		article.setEtatEvaluation("encours");
	}

	@Override
	public Evaluation getEvaluationById(Evaluation_PK pk) {
		return evaluationRepository.getOne(pk);
	}

	@Override
	public void save(Evaluation evaluation) {
		evaluation.setFinished(true);
		evaluationRepository.save(evaluation);
	}

}
