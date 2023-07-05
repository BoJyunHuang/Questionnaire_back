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

	// Questionnaire的流水號
	@Column(name = "qn_number")
	private int qnNumber;

	// 題目
	@Column(name = "question")
	private String question;

	// 類型
	@Column(name = "kind")
	private String kind;

	// 是否必填
	@Column(name = "is_required")
	private boolean isRequired;

	// 選項-使用陣列儲存
	@Column(name = "selections")
	private String selections;

	/*
	 * 建構方法 1.() 2.(serialNumber, qnNumber, question, kind, isRequired, selections)
	 */
	public Questions() {
	}

	public Questions(Integer serialNumber, int qnNumber, String question, String kind, boolean isRequired,
			String selections) {
		super();
		this.serialNumber = serialNumber;
		this.qnNumber = qnNumber;
		this.question = question;
		this.kind = kind;
		this.isRequired = isRequired;
		this.selections = selections;
	}

	// getters & setters
	public Integer getSerialNumber() {
		return serialNumber;
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

}
