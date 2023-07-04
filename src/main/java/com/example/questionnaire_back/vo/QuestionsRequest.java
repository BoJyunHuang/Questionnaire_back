package com.example.questionnaire_back.vo;

import java.util.List;

import com.example.questionnaire_back.entity.Questions;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionsRequest {

	// 屬性
	@JsonProperty("serial_number")
	private Integer serialNumber;
	@JsonProperty("qn_number")
	private int qnNumber;
	private String question;
	private String kind;
	@JsonProperty("is_required")
	private boolean isRequired;
	private String selections;
	@JsonProperty("questions_list")
	private List<Questions> questionsList;
	@JsonProperty("serial_number_list")
	private List<Integer> serialNumberList;
	
	// getters & setters	
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public int getQnNumber() {
		return qnNumber;
	}
	public void setQnNumber(int qnNumber) {
		this.qnNumber = qnNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public boolean isRequired() {
		return isRequired;
	}
	public void setRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}
	public String getSelections() {
		return selections;
	}
	public void setSelections(String selections) {
		this.selections = selections;
	}
	public List<Questions> getQuestionsList() {
		return questionsList;
	}
	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}
	public List<Integer> getSerialNumberList() {
		return serialNumberList;
	}
	public void setSerialNumberList(List<Integer> serialNumberList) {
		this.serialNumberList = serialNumberList;
	}
		
}
