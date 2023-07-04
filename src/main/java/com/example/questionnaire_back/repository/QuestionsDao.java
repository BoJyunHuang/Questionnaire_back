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

	// 修改問題
	@Transactional
	@Modifying
	@Query(value = "update questions set question = :question, kind = :kind, is_required = :isRequired, "
			+ "selections = :selections, where serial_number = :serialNumber", nativeQuery = true)
	public int updateQuestion(@Param("serialNumber") Integer serialNumber, @Param("question") String question,
			@Param("kind") String kind, @Param("isRequired") boolean isRequired,
			@Param("selections") String selections);

	// 尋找問卷中的問題
	@Query(value = "select * from questions where qn_number = :qnNumber", nativeQuery = true)
	public List<Questions> searchQuestions(@Param("qnNumber") int qnNumber);

	// 刪除資料
	@Transactional
	@Modifying
	@Query("delete Questions q where q.serialNumber in :serialNumberList")
	public int deleteQuestions(@Param("serialNumberList") List<Integer> serialNumberList);

	// 刪除整筆資料
	@Transactional
	@Modifying
	@Query("delete Questions q where q.qnNumber = :qnNumber")
	public int deleteQnQuestions(@Param("qnNumber") int qnNumber);

}
