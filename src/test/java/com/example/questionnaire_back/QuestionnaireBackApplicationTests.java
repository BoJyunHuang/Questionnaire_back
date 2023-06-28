package com.example.questionnaire_back;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.entity.Questions;
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

	@BeforeEach
	private void BeforeEach() {
//		qnDao.saveAll(new ArrayList<>(Arrays.asList(
//				new Questionnaire("title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
//						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 10),
//				new Questionnaire("title2", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
//						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 10))));
//		qDao.saveAll(new ArrayList<>(Arrays.asList(new Questions(1, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
//				new Questions(1, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"),
//				new Questions(1, 3, "單選方塊", true, "Q3", "選項1, 選項2, 選項3, 選項4"),
//				new Questions(2, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
//				new Questions(2, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"),
//				new Questions(2, 3, "單選方塊", true, "Q3", "選項1, 選項2, 選項3, 選項4"))));
//		rDao.saveAll(new ArrayList<>(Arrays.asList(
//				new Records("name1", "0911111111", "123@gmail.com", 12, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
//						"1,2,3"),
//				new Records("name2", "0911111112", "124@gmail.com", 18, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
//						"1,2,3"),
//				new Records("name3", "0911111113", "125@gmail.com", 20, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
//						"1,2,3"),
//				new Records("name4", "0911111114", "126@gmail.com", 24, 2, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
//						"1,2,3"),
//				new Records("name5", "0911111115", "127@gmail.com", 30, 2, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
//						"1,2,3"))));
	}

	@Test
	public void insertQuestionnaireTest() {
		Assert.isTrue(qnDao.insertQuestionnaire("title3", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
				LocalDateTime.of(2023, 7, 31, 12, 0, 0)) == 1, RtnCode.TEST1_ERROR.getMessage());
	}

	@Test
	public void updateQuestionnaireTest() {
		Assert.isTrue(qnDao.updateQuestionnaire(null, "title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
				LocalDateTime.of(2023, 7, 31, 12, 0, 0), 0) == 0, RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qnDao.updateQuestionnaire(1, "title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
				LocalDateTime.of(2023, 7, 31, 12, 0, 0), 0) == 1, RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void deleteQuestionnaireTest() {
		Assert.isTrue(qnDao.deleteQuestionnaire(999) == 0, RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qnDao.deleteQuestionnaire(2) == 1, RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void addQuestionnaireTest() {
		Assert.isTrue(
				qnSer.addQuestionnaire(null, null, null, null).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qnSer.addQuestionnaire("test", "des", null, null).getMessage()
				.equals(RtnCode.CANNOT_EMPTY.getMessage()), RtnCode.TEST2_ERROR.getMessage());
		Assert.isTrue(qnSer.addQuestionnaire("test", "des", LocalDateTime.of(2023, 6, 10, 12, 0, 0), null).getMessage()
				.equals(RtnCode.CANNOT_EMPTY.getMessage()), RtnCode.TEST3_ERROR.getMessage());
		Assert.isTrue(
				qnSer.addQuestionnaire("title3", "des", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0)).getMessage().equals(RtnCode.INCORRECT.getMessage()),
				RtnCode.TEST4_ERROR.getMessage());
		Assert.isTrue(
				qnSer.addQuestionnaire("test", "des", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0)).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST5_ERROR.getMessage());
	}

	@Test
	public void reviseQuestionnaireTest() {
		Assert.isTrue(qnSer
				.reviseQuestionnaire(null, "title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 0)
				.getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()), RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(
				qnSer.reviseQuestionnaire(10000, "title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 0).getMessage().equals(RtnCode.INCORRECT.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
		Assert.isTrue(
				qnSer.reviseQuestionnaire(1, "title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 0).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST3_ERROR.getMessage());
	}

	@Test
	public void deleteQuestionnaireImplTest() {
		Assert.isTrue(qnSer.deleteQuestionnaire(null).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qnSer.deleteQuestionnaire(0).getMessage().equals(RtnCode.INCORRECT.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
		Assert.isTrue(qnSer.deleteQuestionnaire(3).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST3_ERROR.getMessage());
	}

	@Test
	public void searchQuestionsTest() {
		Assert.isTrue(qDao.searchQuestions(0).size() == 0, RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qDao.searchQuestions(1).size() == 3, RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void deleteQuestionsTest() {
		Assert.isTrue(qDao.deleteQuestions(null) == 0, RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qDao.deleteQuestions(new ArrayList<>(Arrays.asList(235, 234))) == 2,
				RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void addQuestionsTest() {
		Assert.isTrue(qSer.addQuestions(null).getMessgage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());

		Assert.isTrue(qSer
				.addQuestions(
						new ArrayList<>(Arrays.asList(new Questions(3, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
								new Questions(3, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"))))
				.getMessgage().equals(RtnCode.SUCCESS.getMessage()), RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void showQuestionsTest() {
		Assert.isTrue(qSer.showQuestions(0).getMessgage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qSer.showQuestions(1).getMessgage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void deleteQuestionsImplTest() {
		Assert.isTrue(qSer.deleteQuestions(null).getMessgage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qSer.deleteQuestions(new ArrayList<>(Arrays.asList(0, 1, 2))).getMessgage()
				.equals(RtnCode.INCORRECT.getMessage()), RtnCode.TEST2_ERROR.getMessage());
		Assert.isTrue(qSer.deleteQuestions(new ArrayList<>(Arrays.asList(230))).getMessgage()
				.equals(RtnCode.SUCCESS.getMessage()), RtnCode.TEST3_ERROR.getMessage());
	}

	@Test
	public void insertRecordsTest() {
		Assert.isTrue(rDao.insertRecords("name6", "0911111116", "128@gmail.com", 30, 2,
				LocalDateTime.of(2023, 7, 10, 16, 0, 0), "1,2,3") == 1, RtnCode.TEST1_ERROR.getMessage());
	}

	@Test
	public void searchRecordsTest() {
		Assert.isTrue(rDao.searchRecords(0).size() == 0, RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(rDao.searchRecords(1).size() == 3, RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void addRecordsTest() {
		Assert.isTrue(rSer.addRecords(null, "0911111116", "128@gmail.com", 30, 2, null).getMessage()
				.equals(RtnCode.CANNOT_EMPTY.getMessage()), RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(rSer.addRecords("name6", "0911111116", "128@gmail.com", -30, 2, null).getMessage()
				.equals(RtnCode.CANNOT_EMPTY.getMessage()), RtnCode.TEST2_ERROR.getMessage());
		Assert.isTrue(rSer.addRecords("name6", "0911111116", "128@gmail.com", 30, 2, null).getMessage()
				.equals(RtnCode.CANNOT_EMPTY.getMessage()), RtnCode.TEST3_ERROR.getMessage());
		Assert.isTrue(rSer.addRecords("name6", "0911111116", "128@gmail.com", 30, 2, "1,2,3").getMessage()
				.equals(RtnCode.INCORRECT.getMessage()), RtnCode.TEST4_ERROR.getMessage());
		Assert.isTrue(rSer.addRecords("name7", "0911111117", "129@gmail.com", 30, 2, "1,2,3").getMessage()
				.equals(RtnCode.SUCCESS.getMessage()), RtnCode.TEST5_ERROR.getMessage());
	}

	@Test
	public void findRecordsTest() {
		Assert.isTrue(rSer.findRecords(0).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(rSer.findRecords(2).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
	}

}
