package com.example.questionnaire_back.vo;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuestionnaireRequest {

	// 屬性
	@JsonProperty("serial_number")
	private Integer serialNumber;
	private String title;
	private String description;
	@JsonProperty("start_date")
	private LocalDate startDate;
	@JsonProperty("end_date")
	private LocalDate endDate;
	@JsonProperty("serial_number_list")
	private List<Integer> serialNumberList;
	
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
	public List<Integer> getSerialNumberList() {
		return serialNumberList;
	}
	public void setSerialNumberList(List<Integer> serialNumberList) {
		this.serialNumberList = serialNumberList;
	}
		
}
