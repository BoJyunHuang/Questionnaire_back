package com.example.questionnaire_back.vo;

import java.util.List;

import com.example.questionnaire_back.entity.Questions;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionsResponse {

	// 屬性
	private String messgage;
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

	public QuestionsResponse(String messgage) {
		super();
		this.messgage = messgage;
	}

	public QuestionsResponse(String messgage, List<Questions> questionsList) {
		super();
		this.messgage = messgage;
		this.questionsList = questionsList;
	}

	// getters & setters
	public String getMessgage() {
		return messgage;
	}

	public void setMessgage(String messgage) {
		this.messgage = messgage;
	}

	public List<Questions> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
		
}
