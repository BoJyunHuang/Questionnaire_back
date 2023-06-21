package com.example.questionnaire_back.vo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecordsRequest {

	// 屬性
	@JsonProperty("serial_number")
	private Integer serialNumber;
	private String name;
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String email;
	private int age;
	private String title;
	@JsonProperty("finish_time")
	private LocalDateTime finishTime;
	private String answers;
	
	// getters & setters
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public LocalDateTime getFinishTime() {
		return finishTime;
	}
	public void setFinishTime(LocalDateTime finishTime) {
		this.finishTime = finishTime;
	}
	public String getAnswers() {
		return answers;
	}
	public void setAnswers(String answers) {
		this.answers = answers;
	}
	
}
