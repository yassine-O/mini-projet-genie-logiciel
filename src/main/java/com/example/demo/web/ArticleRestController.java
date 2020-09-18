package com.example.demo.web;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Article;
import com.example.demo.entity.Auteur;
import com.example.demo.service.ArticleService;
import com.example.demo.service.AuteurService;

@RestController
public class ArticleRestController {
	
	@Autowired
	private AuteurService auteurService;
	@Autowired
	private ArticleService articleService;
	
	private static Logger log = Logger.getLogger("service");
	
	@PostMapping("/articles")
	public void ajouterArticle(Principal user, @RequestBody Article article) {
		String email = user.getName();
		Auteur auteur = auteurService.getAuteurByEmail(email);
		articleService.addArticle(auteur, article);
	}
	
	@GetMapping("articles/{id}")
	public Article getArticleById(@PathVariable long id) {
		return articleService.getArticleById(id);
	}
	
	@PutMapping("articles/{id}")
	public void updateArticle(@PathVariable long id, @RequestBody Article article) {
		Article oldArticle = articleService.getArticleById(id);
		if(!oldArticle.getEtatEvaluation().equals("encours")) {
			article.setId(id);
			articleService.save(article);
			log.info("article : "+article.getId()+" modified");
		}
	}
	
	@DeleteMapping("articles/{id}")
	public void deleteArticle(@PathVariable long id) {
		Article article = articleService.getArticleById(id);
		if(!article.getEtatEvaluation().equals("encours")) {
			articleService.delete(article);
			log.info("article : "+article.getId()+" deleted");
		}
	}
	
	@GetMapping(value = "ArticlesInfo", params = "{nomAuteur}")
	public List<Article> getArticlesByAuteurNom(@RequestParam("nomAuteur") String nomAuteur){
		return articleService.getArticlesByAuteurNom(nomAuteur);
	}
	
	@GetMapping(value = "ArticlesInfo", params = "{motsCles}")
	public List<Article> getArticlesByMotsCles(@RequestParam("motsCles") String motsCles){
		return articleService.getArticlesByMotsCles(motsCles);
	}

}
