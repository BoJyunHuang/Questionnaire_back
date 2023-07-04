package com.example.questionnaire_back.service.ifs;

import java.time.LocalDate;

import com.example.questionnaire_back.vo.QuestionnaireResponse;

public interface QuestionnaireService {

	// 顯示所有問卷
	public QuestionnaireResponse showAllQuestionnaires();

	// 新增問卷
	public QuestionnaireResponse addQuestionnaire(String title, String description, LocalDate startDate,
			LocalDate endDate);

	// 修改問卷
	public QuestionnaireResponse reviseQuestionnaire(Integer serialNumber, String title, String description,
			LocalDate startDate, LocalDate endDate);

	// 刪除問卷
	public QuestionnaireResponse deleteQuestionnaire(Integer serialNumber);
}
