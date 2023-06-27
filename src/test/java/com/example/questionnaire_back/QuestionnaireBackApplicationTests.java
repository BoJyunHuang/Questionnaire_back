package com.example.questionnaire_back;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.questionnaire_back.entity.Questionnaire;
import com.example.questionnaire_back.entity.Questions;
import com.example.questionnaire_back.entity.Records;
import com.example.questionnaire_back.repository.QuestionnaireDao;
import com.example.questionnaire_back.repository.QuestionsDao;
import com.example.questionnaire_back.repository.RecordsDao;
import com.example.questionnaire_back.service.ifs.QuestionnaireService;
import com.example.questionnaire_back.service.ifs.QuestionsService;
import com.example.questionnaire_back.service.ifs.RecordsService;

@SpringBootTest(classes = QuestionnaireBackApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class QuestionnaireBackApplicationTests {

	@Autowired
	private QuestionnaireDao qnDao;

	@Autowired
	private QuestionsDao qDao;

	@Autowired
	private RecordsDao rDao;

	@Autowired
	private QuestionnaireService qnSer;

	@Autowired
	private QuestionsService qSer;

	@Autowired
	private RecordsService rSer;

	@BeforeAll
	private void BeforeAll() {
		qnDao.saveAll(new ArrayList<>(Arrays.asList(
				new Questionnaire("title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 10),
				new Questionnaire("title2", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 10))));
		qDao.saveAll(new ArrayList<>(Arrays.asList(new Questions(1, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
				new Questions(1, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"),
				new Questions(1, 3, "單選方塊", true, "Q3", "選項1, 選項2, 選項3, 選項4"),
				new Questions(2, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
				new Questions(2, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"),
				new Questions(2, 3, "單選方塊", true, "Q3", "選項1, 選項2, 選項3, 選項4"))));
		rDao.saveAll(new ArrayList<>(Arrays.asList(
				new Records("name1", "0911111111", "123@gmail.com", 12, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records("name2", "0911111112", "124@gmail.com", 18, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records("name3", "0911111113", "125@gmail.com", 20, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records("name4", "0911111114", "126@gmail.com", 24, 2, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records("name5", "0911111115", "127@gmail.com", 30, 2, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"))));
	}

	@AfterAll
	private void AfterAll() {

	}

	@Test
	public void insertQuestionnaireTest() {
	}

	@Test
	public void updateQuestionnaireTest() {
	}

	@Test
	public void deleteQuestionnaireTest() {
	}

	@Test
	public void addQuestionnaireTest() {
	}

	@Test
	public void reviseQuestionnaireTest() {
	}

	@Test
	public void deleteQuestionnaireImplTest() {
	}

	@Test
	public void searchQuestionsTest() {
	}

	@Test
	public void deleteQuestionsTest() {
	}

	@Test
	public void addQuestionsTest() {
	}

	@Test
	public void showQuestionsTest() {
	}

	@Test
	public void deleteQuestionsImplTest() {
	}

	@Test
	public void insertRecordsTest() {
	}

	@Test
	public void searchRecordsTest() {
	}

	@Test
	public void addRecordsTest() {
	}

	@Test
	public void findRecordsTest() {
	}

}
