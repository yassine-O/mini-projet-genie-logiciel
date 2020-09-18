package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.AuteurRepository;
import com.example.demo.entity.Auteur;
import com.example.demo.service.AuteurService;

@Service
@Transactional
public class AuteurServiceImpl implements AuteurService {
	
	@Autowired
	private AuteurRepository auteurRepository;

	@Override
	public Auteur getAuteurByEmail(String email) {
		return auteurRepository.findAuteurByEmail(email);
	}
	
}
