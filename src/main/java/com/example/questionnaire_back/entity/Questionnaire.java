package com.example.questionnaire_back.entity;

import java.time.LocalDate;

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

	// 開始時間
	@Column(name = "start_date")
	private LocalDate startDate;

	// 結束時間
	@Column(name = "end_date")
	private LocalDate endDate;

	/*
	 * 建構方法 1.() 2.(serialNumber, title, description, startDate, endDate)
	 */
	public Questionnaire() {
	}

	public Questionnaire(Integer serialNumber, String title, String description, LocalDate startDate,
			LocalDate endDate) {
		super();
		this.serialNumber = serialNumber;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
