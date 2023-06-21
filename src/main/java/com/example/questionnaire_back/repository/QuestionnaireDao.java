package com.example.questionnaire_back.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire_back.entity.Questionnaire;

@Repository
public interface QuestionnaireDao extends JpaRepository<Questionnaire, Integer> {

	// 新增問卷
	@Transactional
	@Modifying
	@Query(value = "insert into questionnaire (title, description, status, start_time, end_time, question_amount) "
			+ "select :title, :description, :status, :startTime, :endTime, :questionAmount "
			+ "where not exists (select 1 from questionnaire where title = :title)", nativeQuery = true)
	public int insertQuestionnaire(@Param("title") String title, @Param("description") String description,
			@Param("status") String status, @Param("startTime") LocalDateTime startTime,
			@Param("endTime") LocalDateTime endTime, @Param("questionAmount") int questionAmount);

	// 修改問卷
	@Transactional
	@Modifying
	@Query(value = "update questionnaire set description = :description, status = :status, start_time = :startTime, "
			+ "end_time = :endTime, question_amount = :questionAmount where title = :title", nativeQuery = true)
	public int updateQuestionnaire(@Param("title") String title, @Param("description") String description,
			@Param("status") String status, @Param("startTime") LocalDateTime startTime,
			@Param("endTime") LocalDateTime endTime, @Param("questionAmount") int questionAmount);
}
