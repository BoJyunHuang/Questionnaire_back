package com.example.questionnaire_back.vo;

import java.util.List;

import com.example.questionnaire_back.entity.Records;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RecordsResponse {

	// 屬性
	private String message;
	@JsonProperty("records_list")
	private List<Records> recordsList;

	/*
	 * 建構方法: 
	 * 1.() 
	 * 2.(message) 
	 * 3.(message, recordsList)
	 */
	public RecordsResponse() {
	}

	public RecordsResponse(String message) {
		super();
		this.message = message;
	}

	public RecordsResponse(String message, List<Records> recordsList) {
		super();
		this.message = message;
		this.recordsList = recordsList;
	}

	// getters & setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Records> getRecordsList() {
		return recordsList;
	}

	public void setRecordsList(List<Records> recordsList) {
		this.recordsList = recordsList;
	}
	
}
