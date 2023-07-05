package com.example.questionnaire_back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire_back.entity.Questions;

@Repository
public interface QuestionsDao extends JpaRepository<Questions, Integer> {

	// 尋找問卷中的問題
	@Query(value = "select * from questions where qn_number = :qnNumber", nativeQuery = true)
	public List<Questions> searchQuestions(@Param("qnNumber") int qnNumber);

	// 刪除資料
	@Transactional
	@Modifying
	@Query("delete Questions q where q.serialNumber in :serialNumberList or q.qnNumber = :qnNumber")
	public int deleteQuestions(@Param("serialNumberList") List<Integer> serialNumberList,
			@Param("qnNumber") int qnNumber);

}
