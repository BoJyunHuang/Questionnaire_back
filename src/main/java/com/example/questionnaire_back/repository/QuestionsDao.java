package com.example.questionnaire_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.questionnaire_back.entity.Questions;

@Repository
public interface QuestionsDao extends JpaRepository<Questions, Integer>{

}
