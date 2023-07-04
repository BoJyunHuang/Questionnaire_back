package com.example.questionnaire_back.vo;

import java.util.List;

import com.example.questionnaire_back.entity.Questionnaire;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionnaireResponse {

	// 屬性
	private String message;
	private Questionnaire questionnaire;
	@JsonProperty("questionnaire_list")
	private List<Questionnaire> questionnaireList;

	/*
	 * 建構方法
	 * 1.()
	 * 2.(message)
	 * 3.(message, questionnaire)
	 * 4.(message, questionnaireList)
	 */
	public QuestionnaireResponse() {
	}

	public QuestionnaireResponse(String message) {
		super();
		this.message = message;
	}

	public QuestionnaireResponse(String message, Questionnaire questionnaire) {
		super();
		this.message = message;
		this.questionnaire = questionnaire;
	}

	public QuestionnaireResponse(String message, List<Questionnaire> questionnaireList) {
		super();
		this.message = message;
		this.questionnaireList = questionnaireList;
	}

	// getters & setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public List<Questionnaire> getQuestionnaireList() {
		return questionnaireList;
	}

	public void setQuestionnaireList(List<Questionnaire> questionnaireList) {
		this.questionnaireList = questionnaireList;
	}

}
