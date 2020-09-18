package com.example.demo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor
public class Manuscrit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private byte[] contenu;
	
	@OneToOne(mappedBy = "manuscrit")
	private Article article;
	
	@OneToMany(mappedBy = "pk.manuscrit")
	private List<Evaluation> evaluation;

}
