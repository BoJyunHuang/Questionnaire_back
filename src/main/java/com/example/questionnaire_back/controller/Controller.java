package com.example.questionnaire_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.questionnaire_back.service.ifs.QuestionnaireService;
import com.example.questionnaire_back.service.ifs.QuestionsService;
import com.example.questionnaire_back.service.ifs.RecordsService;
import com.example.questionnaire_back.vo.QuestionnaireRequest;
import com.example.questionnaire_back.vo.QuestionnaireResponse;
import com.example.questionnaire_back.vo.QuestionsRequest;
import com.example.questionnaire_back.vo.QuestionsResponse;
import com.example.questionnaire_back.vo.RecordsRequest;
import com.example.questionnaire_back.vo.RecordsResponse;

@CrossOrigin
@RestController
public class Controller {

	@Autowired
	private QuestionnaireService questionnaireService;
	@Autowired
	private QuestionsService questionsService;
	@Autowired
	private RecordsService recordsService;

	// 顯示所有問卷
	@GetMapping(value = "show_all_questionnaires")
	public QuestionnaireResponse showAllQuestionnaires() {
		return questionnaireService.showAllQuestionnaires();
	};

	// 新增問卷
	@PostMapping(value = "add_questionnaire")
	public QuestionnaireResponse addQuestionnaire(@RequestBody QuestionnaireRequest request) {
		return questionnaireService.addQuestionnaire(request.getTitle(), request.getDescription(),
				request.getStartDate(), request.getEndDate());
	};

	// 修改問卷
	@PostMapping(value = "revise_questionnaire")
	public QuestionnaireResponse reviseQuestionnaire(@RequestBody QuestionnaireRequest request) {
		return questionnaireService.reviseQuestionnaire(request.getSerialNumber(), request.getTitle(),
				request.getDescription(), request.getStartDate(), request.getEndDate());
	};

	// 刪除問卷
	@DeleteMapping(value = "delete_questionnaire")
	public QuestionnaireResponse deleteQuestionnaire(@RequestBody QuestionnaireRequest request) {
		return questionnaireService.deleteQuestionnaire(request.getSerialNumber());
	};

	// 新增問題集
	@PostMapping(value = "add_questions")
	public QuestionsResponse addQuestions(@RequestBody QuestionsRequest request) {
		return questionsService.addQuestions(request.getQuestionsList());
	};

	// 修改問題集
	@PostMapping(value = "revise_question")
	public QuestionsResponse reviseQuestion(@RequestBody QuestionsRequest request) {
		return questionsService.reviseQuestion(request.getSerialNumber(), request.getQuestion(), request.getKind(),
				request.isRequired(), request.getSelections());
	};

	// 顯示該問卷問題集
	@PostMapping(value = "show_questions")
	public QuestionsResponse showQuestions(@RequestBody QuestionsRequest request) {
		return questionsService.showQuestions(request.getQnNumber());
	};

	// 刪除問題集
	@DeleteMapping(value = "delete_questions")
	public QuestionsResponse deleteQuestions(@RequestBody QuestionsRequest request) {
		return questionsService.deleteQuestions(request.getSerialNumberList());
	};

	// 刪除問卷問題集
	@DeleteMapping(value = "delete_qn_questions")
	public QuestionsResponse deleteQnQuestions(@RequestBody QuestionsRequest request) {
		return questionsService.deleteQnQuestions(request.getQnNumber());
	};

	// 新增使用者回答
	@PostMapping(value = "add_records")
	public RecordsResponse addRecords(@RequestBody RecordsRequest request) {
		return recordsService.addRecords(request.getName(), request.getPhoneNumber(), request.getEmail(),
				request.getAge(), request.getQnNumber(), request.getAnswers());
	};

	// 查詢使用者填答
	@PostMapping(value = "find_records")
	public RecordsResponse findRecords(@RequestBody RecordsRequest request) {
		return recordsService.findRecords(request.getQnNumber());
	};
}
