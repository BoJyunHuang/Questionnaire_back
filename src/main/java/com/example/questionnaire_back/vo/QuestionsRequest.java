package com.example.questionnaire_back.vo;

import java.util.List;

import com.example.questionnaire_back.entity.Questions;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionsRequest {

	// 屬性
	@JsonProperty("serial_number")
	private Integer serialNumber;
	private String title;
	private int number;
	private String kind;
	@JsonProperty("not_empty")
	private boolean notEmpty;
	private String question;
	private String selection;
	@JsonProperty("questions_list")
	private List<Questions> questionsList;
	
	// getters & setters
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public boolean isNotEmpty() {
		return notEmpty;
	}
	public void setNotEmpty(boolean notEmpty) {
		this.notEmpty = notEmpty;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSelection() {
		return selection;
	}
	public void setSelection(String selection) {
		this.selection = selection;
	}
	public List<Questions> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
	
}
