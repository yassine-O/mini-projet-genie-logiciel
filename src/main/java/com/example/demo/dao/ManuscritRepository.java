package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Manuscrit;

public interface ManuscritRepository extends JpaRepository<Manuscrit, Long> {

}
