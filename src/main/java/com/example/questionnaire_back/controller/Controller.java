package com.example.questionnaire_back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest request) {
		return questionnaireService.addQuestionnaire(request);
	};

	// 修改問卷
	@PostMapping(value = "revise_questionnaire")
	public QuestionnaireResponse reviseQuestionnaire(QuestionnaireRequest request) {
		return questionnaireService.reviseQuestionnaire(request);
	};

	// 刪除問卷
	@PostMapping(value = "delete_questionnaire")
	public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest request) {
		return questionnaireService.deleteQuestionnaire(request);
	};

	// 新增問題集
	@PostMapping(value = "add_questions")
	public QuestionsResponse addQuestions(QuestionsRequest request) {
		return questionsService.addQuestions(request);
	};

	// 顯示該問卷問題集
	@PostMapping(value = "show_questions")
	public QuestionsResponse showQuestions(QuestionsRequest request) {
		return questionsService.showQuestions(request);
	};

	// 修改該問卷問題集
	@PostMapping(value = "revise_questions")
	public QuestionsResponse reviseQuestions(QuestionsRequest request) {
		return questionsService.reviseQuestions(request);
	};

	// 刪除問題集
	@PostMapping(value = "delete_questions")
	public QuestionsResponse deleteQuestions(QuestionsRequest request) {
		return questionsService.deleteQuestions(request);
	};

	// 新增使用者回答
	@PostMapping(value = "add_records")
	public RecordsResponse addRecords(RecordsRequest request) {
		return recordsService.addRecords(request);
	};

	// 查詢使用者填答
	@PostMapping(value = "find_records")
	public RecordsResponse findRecords(RecordsRequest request) {
		return recordsService.findRecords(request);
	};
}
