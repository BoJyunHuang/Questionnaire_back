package com.example.questionnaire_back.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionnaireRequest {

	// 屬性
	@JsonProperty("serial_number")
	private Integer serialNumber;
	private String title;
	private String description;
	private String status;
	@JsonProperty("start_time")
	private LocalDateTime startTime;
	@JsonProperty("end_time")
	private LocalDateTime endTime;
	@JsonProperty("question_amount")
	private Integer questionAmount;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public Integer getQuestionAmount() {
		return questionAmount;
	}
	public void setQuestionAmount(Integer questionAmount) {
		this.questionAmount = questionAmount;
	}
	
}
