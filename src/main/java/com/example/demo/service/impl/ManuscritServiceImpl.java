package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.dao.ManuscritRepository;
import com.example.demo.entity.Manuscrit;
import com.example.demo.service.ManuscritService;

public class ManuscritServiceImpl implements ManuscritService {
	
	@Autowired
	private ManuscritRepository manuscritRepository;

	@Override
	public Manuscrit getById(long id) {
		return manuscritRepository.getOne(id);
	}

}
