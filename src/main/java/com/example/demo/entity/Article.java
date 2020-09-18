package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Article {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titreArticle;
	
	private String resume;
	
	private String motsCles;
	
	private String coAuteurs;
	
	private String affiliations;
	
	private String decisionComite;
	
	private boolean publication;
	
	private String etatEvaluation;
	
	@OneToOne
	@JoinColumn(name = "code_manuscrit")
	private Manuscrit manuscrit;
	
	@ManyToOne
	@JoinColumn(name = "code_auteur")
	private Auteur auteur;
	 

}
