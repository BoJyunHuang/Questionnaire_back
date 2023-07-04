package com.example.questionnaire_back.vo;

import java.util.List;

import com.example.questionnaire_back.entity.Questions;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionsResponse {

	// 屬性
	private String message;
	@JsonProperty("questions_list")
	private List<Questions> questionsList;
	
	/*
	 * 建構方法
	 * 1.()
	 * 2.(message)
	 * 3.(message, questionnaire)
	 */
	public QuestionsResponse() {
	}

	public QuestionsResponse(String message) {
		super();
		this.message = message;
	}

	public QuestionsResponse(String message, List<Questions> questionsList) {
		super();
		this.message = message;
		this.questionsList = questionsList;
	}

	// getters & setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Questions> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
		
}
