package com.example.questionnaire_back;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.entity.Questionnaire;
import com.example.questionnaire_back.entity.Questions;
import com.example.questionnaire_back.entity.Records;
import com.example.questionnaire_back.repository.QuestionnaireDao;
import com.example.questionnaire_back.repository.QuestionsDao;
import com.example.questionnaire_back.repository.RecordsDao;
import com.example.questionnaire_back.service.ifs.QuestionnaireService;
import com.example.questionnaire_back.service.ifs.QuestionsService;
import com.example.questionnaire_back.service.ifs.RecordsService;
import com.example.questionnaire_back.vo.QuestionnaireRequest;
import com.example.questionnaire_back.vo.QuestionsRequest;
import com.example.questionnaire_back.vo.RecordsRequest;

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
		qnDao.saveAll(new ArrayList<>(Arrays.asList(
				new Questionnaire(1, "title1", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 10),
				new Questionnaire(2, "title2", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
						LocalDateTime.of(2023, 7, 31, 12, 0, 0), 10))));
		qDao.saveAll(new ArrayList<>(Arrays.asList(new Questions(1, 1, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
				new Questions(2, 1, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"),
				new Questions(3, 1, 3, "單選方塊", true, "Q3", "選項1, 選項2, 選項3, 選項4"),
				new Questions(4, 2, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
				new Questions(5, 2, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"),
				new Questions(6, 2, 3, "單選方塊", true, "Q3", "選項1, 選項2, 選項3, 選項4"))));
		rDao.saveAll(new ArrayList<>(Arrays.asList(
				new Records(1, "name1", "0911111111", "123@gmail.com", 12, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records(2, "name2", "0911111112", "124@gmail.com", 18, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records(3, "name3", "0911111113", "125@gmail.com", 20, 1, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records(4, "name4", "0911111114", "126@gmail.com", 24, 2, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"),
				new Records(5, "name5", "0911111115", "127@gmail.com", 30, 2, LocalDateTime.of(2023, 7, 10, 16, 0, 0),
						"1,2,3"))));
	}

	@AfterAll
	private void AfterAll() {
		qnDao.deleteAll();
		qDao.deleteAll();
		rDao.deleteAll();
	}

	@Test
	public void insertQuestionnaireTest() {
		Assert.isTrue(qnDao.insertQuestionnaire("title3", "des", "未開放", LocalDateTime.of(2023, 6, 30, 12, 0, 0),
				LocalDateTime.of(2023, 7, 31, 12, 0, 0), 0) == 1, RtnCode.TEST1_ERROR.getMessage());
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
		QuestionnaireRequest request = new QuestionnaireRequest();
		Assert.isTrue(qnSer.addQuestionnaire(null).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qnSer.addQuestionnaire(request).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
		request.setTitle("title10");
		request.setDescription("des");
		request.setStatus("未開放");
		Assert.isTrue(qnSer.addQuestionnaire(request).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST3_ERROR.getMessage());
		request.setStartTime(LocalDateTime.of(2023, 6, 30, 12, 0, 0));
		request.setEndTime(LocalDateTime.of(2023, 7, 31, 12, 0, 0));
		Assert.isTrue(qnSer.addQuestionnaire(request).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST4_ERROR.getMessage());
		request.setQuestionAmount(0);
		Assert.isTrue(qnSer.addQuestionnaire(request).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST5_ERROR.getMessage());
	}

	@Test
	public void reviseQuestionnaireTest() {
		QuestionnaireRequest request = new QuestionnaireRequest();
		Assert.isTrue(qnSer.reviseQuestionnaire(null).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		Assert.isTrue(qnSer.reviseQuestionnaire(request).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
		request.setSerialNumber(0);
		request.setTitle("title10");
		request.setDescription("des");
		request.setStatus("未開放");
		Assert.isTrue(qnSer.reviseQuestionnaire(request).getMessage().equals(RtnCode.INCORRECT.getMessage()),
				RtnCode.TEST3_ERROR.getMessage());
		request.setStartTime(LocalDateTime.of(2023, 6, 30, 12, 0, 0));
		request.setEndTime(LocalDateTime.of(2023, 7, 31, 12, 0, 0));
		request.setQuestionAmount(0);
		request.setSerialNumber(1);
		Assert.isTrue(qnSer.reviseQuestionnaire(request).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST4_ERROR.getMessage());
	}

	@Test
	public void deleteQuestionnaireImplTest() {
		QuestionnaireRequest request = new QuestionnaireRequest();
		Assert.isTrue(qnSer.deleteQuestionnaire(null).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		request.setSerialNumber(0);
		Assert.isTrue(qnSer.deleteQuestionnaire(request).getMessage().equals(RtnCode.INCORRECT.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
		request.setSerialNumber(2);
		Assert.isTrue(qnSer.deleteQuestionnaire(request).getMessage().equals(RtnCode.SUCCESS.getMessage()),
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
		Assert.isTrue(qDao.deleteQuestions(new ArrayList<>(Arrays.asList(0, 2, 3))) == 2,
				RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void addQuestionsTest() {
		Assert.isTrue(qSer.addQuestions(null).getMessgage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		QuestionsRequest request = new QuestionsRequest();
		request.setQuestionsList(
				new ArrayList<>(Arrays.asList(new Questions(3, 1, "單選方塊", true, "Q1", "選項1, 選項2, 選項3, 選項4"),
						new Questions(3, 2, "單選方塊", true, "Q2", "選項1, 選項2, 選項3, 選項4"))));
		Assert.isTrue(qSer.addQuestions(request).getMessgage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void showQuestionsTest() {
		Assert.isTrue(qSer.showQuestions(null).getMessgage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		QuestionsRequest request = new QuestionsRequest();
		request.setQnNumber(1);
		Assert.isTrue(qSer.showQuestions(request).getMessgage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
	}

	@Test
	public void deleteQuestionsImplTest() {
		Assert.isTrue(qSer.deleteQuestions(null).getMessgage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		QuestionsRequest request = new QuestionsRequest();
		request.setSerialNumberList(new ArrayList<>(Arrays.asList(0, 1, 2)));
		Assert.isTrue(qSer.deleteQuestions(request).getMessgage().equals(RtnCode.INCORRECT.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
		request.setSerialNumberList(new ArrayList<>(Arrays.asList(1, 2)));
		Assert.isTrue(qSer.deleteQuestions(request).getMessgage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST3_ERROR.getMessage());
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
		Assert.isTrue(rSer.addRecords(null).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		RecordsRequest request = new RecordsRequest();
		Assert.isTrue(rSer.addRecords(request).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
		request.setName("name6");
		request.setPhoneNumber("0911111117");
		request.setEmail("129@gmail.com");
		request.setAge(48);
		Assert.isTrue(rSer.addRecords(request).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST3_ERROR.getMessage());
		request.setQnNumber(1);
		request.setFinishTime(LocalDateTime.of(2023, 7, 10, 16, 0, 0));
		request.setAnswers("1,2,3");
		Assert.isTrue(rSer.addRecords(request).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST4_ERROR.getMessage());
	}

	@Test
	public void findRecordsTest() {
		Assert.isTrue(rSer.findRecords(null).getMessage().equals(RtnCode.CANNOT_EMPTY.getMessage()),
				RtnCode.TEST1_ERROR.getMessage());
		RecordsRequest request = new RecordsRequest();
		request.setQnNumber(2);;
		Assert.isTrue(rSer.addRecords(request).getMessage().equals(RtnCode.SUCCESS.getMessage()),
				RtnCode.TEST2_ERROR.getMessage());
	}

}
