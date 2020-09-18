package com.example.demo.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.Auteur;
import com.example.demo.entity.Evaluation;
import com.example.demo.entity.Evaluation_PK;
import com.example.demo.entity.Manuscrit;
import com.example.demo.service.ArticleService;
import com.example.demo.service.AuteurService;
import com.example.demo.service.EvaluationService;
import com.example.demo.service.ManuscritService;

@RestController
public class EvaluationRestController {
	
	@Autowired
	private EvaluationService evaluationService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ManuscritService manuscritService;
	@Autowired
	private AuteurService auteurService;
	
	@PostMapping("/affecter/{idArticle}")
	public void affecter(@PathVariable long idArticle, @RequestBody List<Auteur> referees) {
		Article article = articleService.getArticleById(idArticle);
		for(Auteur referee : referees) {
			evaluationService.affectation(article, referee);
		}
	}
	
	@PostMapping("evaluer/{idManuscrit}")
	public void evaluer(Principal user, @PathVariable long idManuscrit, @RequestBody String qualification, @RequestBody String commentaires) {
		String email = user.getName();
		Auteur referee = auteurService.getAuteurByEmail(email);
		Manuscrit manuscrit = manuscritService.getById(idManuscrit);
		Evaluation_PK pk = new Evaluation_PK(manuscrit, referee);
		Evaluation evaluation = evaluationService.getEvaluationById(pk);
		evaluation.setQualification(qualification);
		evaluation.setCommentaires(commentaires);
		evaluationService.save(evaluation);
	}
	
	@GetMapping("evaluations/{idArticle}")
	public List<Evaluation> getEvaluations(Principal user, @PathVariable long idArticle) {
		String email = user.getName();
		Auteur auteur = auteurService.getAuteurByEmail(email);
		Article article = articleService.getArticleById(idArticle);
		if(auteur.getArticles().contains(article) | auteur.getRole().equals("COMITE")) {
			return article.getManuscrit().getEvaluation();
		}
		else {
			return null;
		}
	}
	
	@PostMapping("/qualifier/{idArticle}")
	public void qualifier(@PathVariable long idArticle, @RequestBody String decisionComite) {
		Article article = articleService.getArticleById(idArticle);
		article.setDecisionComite(decisionComite);
		articleService.save(article);
	}

}
