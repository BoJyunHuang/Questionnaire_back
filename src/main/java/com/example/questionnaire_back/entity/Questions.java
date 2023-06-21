package com.example.questionnaire_back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {

	// 流水號
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "serial_number")
	private Integer serialNumber;

	// Questionnaire的標題
	@Column(name = "title")
	private String title;

	// 題號
	@Column(name = "number")
	private int number;

	// 類型
	@Column(name = "kind")
	private String kind;

	// 是否必填
	@Column(name = "not_empty")
	private boolean notEmpty;

	// 題目
	@Column(name = "question")
	private String question;

	// 選項-使用陣列儲存
	@Column(name = "selection")
	private String selection;

	/*
	 * 建構方法
	 * 1.() 
	 * 2.(title, number, kind, notEmpty, question, selection)
	 */
	public Questions() {
	}

	public Questions(String title, int number, String kind, boolean notEmpty, String question, String selection) {
		super();
		this.title = title;
		this.number = number;
		this.kind = kind;
		this.notEmpty = notEmpty;
		this.question = question;
		this.selection = selection;
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
	
}
