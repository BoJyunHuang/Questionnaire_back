package com.example.questionnaire_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire_back.entity.Questionnaire;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {

	// 刪除問卷
	@Transactional
	@Modifying
	@Query("delete Questionnaire q where q.serialNumber = :serialNumber")
	public int deleteQuestionnaire(@Param("serialNumber") Integer serialNumber);
}
