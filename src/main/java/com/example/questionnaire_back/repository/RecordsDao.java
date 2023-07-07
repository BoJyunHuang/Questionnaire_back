package com.example.questionnaire_back.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.questionnaire_back.entity.Records;

@Repository
public interface RecordsDao extends JpaRepository<Records, Integer> {

	// 新增回答
	@Transactional
	@Modifying
	@Query(value = "insert into records (name, phone_number, email, age, qn_number, finish_time, answers) "
			+ "select :name, :phoneNumber, :email, :age, :qnNumber, :finishTime, :answers "
			+ "where not exists (select 1 from records where name = :name and qn_number = :qnNumber)", nativeQuery = true)
	public int insertRecords(@Param("name") String name, @Param("phoneNumber") String phoneNumber,
			@Param("email") String email, @Param("age") int age, @Param("qnNumber") int qnNumber,
			@Param("finishTime") LocalDateTime finishTime, @Param("answers") String answers);

	// 尋找回答
	@Query(value = "select * from records where qn_number = :qnNumber order by serial_number desc", nativeQuery = true)
	public List<Records> searchRecords(@Param("qnNumber") int qnNumber);
}
