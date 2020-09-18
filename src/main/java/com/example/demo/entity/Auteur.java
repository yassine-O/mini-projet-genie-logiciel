package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Auteur extends Utilisateur {
	
	@OneToMany(mappedBy = "auteur")
	private List<Article> articles = new ArrayList<Article>();
	
	@OneToMany(mappedBy = "pk.referee")
	List<Evaluation> evaluations = new ArrayList<>();

}
