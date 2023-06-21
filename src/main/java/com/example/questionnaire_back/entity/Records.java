package com.example.questionnaire_back.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "records")
public class Records {

	// 流水號
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_number")
	private Integer serialNumber;

	// 姓名
	@Column(name = "name")
	private String name;

	// 手機號碼
	@Column(name = "phone_number")
	private String phoneNumber;

	// 電子信箱
	@Column(name = "email")
	private String email;

	// 年齡
	@Column(name = "age")
	private int age;

	// Questionnaire的標題
	@Column(name = "title")
	private String title;

	// 完成時間
	@Column(name = "finish_time")
	private LocalDateTime finishTime;

	// 回答-使用陣列儲存
	@Column(name = "answers")
	private String answers;

	/*
	 * 建構方法
	 * 1.() 
	 * 2.(name, phoneNumber, email, age, title, finishTime, answers)
	 */
	public Records() {
	}

	public Records(String name, String phoneNumber, String email, int age, String title, LocalDateTime finishTime,
			String answers) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.age = age;
		this.title = title;
		this.finishTime = finishTime;
		this.answers = answers;
	}

	// getters & setters
	public Integer getSerialNumber() {
		return serialNumber;
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
