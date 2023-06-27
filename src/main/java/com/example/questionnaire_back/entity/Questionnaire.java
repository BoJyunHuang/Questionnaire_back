package com.example.questionnaire_back.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questionnaire")
public class Questionnaire {

	// 流水號
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_number")
	private Integer serialNumber;

	// 標題
	@Column(name = "title")
	private String title;

	// 說明
	@Column(name = "description")
	private String description;

	// 狀態
	@Column(name = "status")
	private String status;

	// 開始時間
	@Column(name = "start_time")
	private LocalDateTime startTime;

	// 結束時間
	@Column(name = "end_time")
	private LocalDateTime endTime;

	// 題目數量
	@Column(name = "question_amount")
	private int questionAmount;

	/*
	 * 建構方法
	 * 1.() 
	 * 2.(title, description, status, startTime, endTime, questionAmount)
	 * 3.(serialNumber, title, description, status, startTime, endTime, questionAmount)
	 */
	public Questionnaire() {
	}

	public Questionnaire(String title, String description, String status, LocalDateTime startTime,
			LocalDateTime endTime, int questionAmount) {
		super();
		this.title = title;
		this.description = description;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.questionAmount = questionAmount;
	}

	public Questionnaire(Integer serialNumber, String title, String description, String status, LocalDateTime startTime,
			LocalDateTime endTime, int questionAmount) {
		super();
		this.serialNumber = serialNumber;
		this.title = title;
		this.description = description;
		this.status = status;
		this.startTime = startTime;
		this.endTime = endTime;
		this.questionAmount = questionAmount;
	}

	// getters & setters
	public Integer getSerialNumber() {
		return serialNumber;
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

	public int getQuestionAmount() {
		return questionAmount;
	}

	public void setQuestionAmount(int questionAmount) {
		this.questionAmount = questionAmount;
	}
	
}
