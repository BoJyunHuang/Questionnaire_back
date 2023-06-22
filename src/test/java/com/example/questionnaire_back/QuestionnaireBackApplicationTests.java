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
				new Questionnaire("title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 10))));
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
