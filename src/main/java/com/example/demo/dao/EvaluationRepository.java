package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Evaluation;
import com.example.demo.entity.Evaluation_PK;

public interface EvaluationRepository extends JpaRepository<Evaluation, Evaluation_PK> {

}
