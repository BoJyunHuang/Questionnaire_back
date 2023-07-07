package com.example.questionnaire_back.vo;

import java.util.List;

import com.example.questionnaire_back.entity.Questions;
import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionsRequest {

	// 屬性
	@JsonProperty("qn_number")
	private int qnNumber;
	@JsonProperty("questions_list")
	private List<Questions> questionsList;
	@JsonProperty("serial_number_list")
	private List<Integer> serialNumberList;
	@JsonProperty("qn_number_list")
	private List<Integer> qnNumberList;

	// getters & setters
	public int getQnNumber() {
		return qnNumber;
	}

	public void setQnNumber(int qnNumber) {
		this.qnNumber = qnNumber;
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

	public List<Integer> getQnNumberList() {
		return qnNumberList;
	}

	public void setQnNumberList(List<Integer> qnNumberList) {
		this.qnNumberList = qnNumberList;
	}

}
