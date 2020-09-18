package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
	
	public Auteur findAuteurByEmail(String email);

}
