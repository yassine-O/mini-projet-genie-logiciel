package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Evaluation {
	
	@Id
	private Evaluation_PK pk;
	
	private String qualification;
	
	private String commentaires;
	
	private boolean finished;
	
	
	public Evaluation(Manuscrit manuscrit, Auteur referee) {
		this.pk = new Evaluation_PK(manuscrit, referee);
	}

}
