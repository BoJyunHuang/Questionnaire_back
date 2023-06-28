package com.example.questionnaire_back.service.ifs;

import java.time.LocalDateTime;

import com.example.questionnaire_back.vo.QuestionnaireResponse;

public interface QuestionnaireService {

	// 顯示所有問卷
	public QuestionnaireResponse showAllQuestionnaires();

	// 新增問卷
	public QuestionnaireResponse addQuestionnaire(String title, String description, LocalDateTime startTime,
			LocalDateTime endTime);

	// 修改問卷
	public QuestionnaireResponse reviseQuestionnaire(Integer serialNumber, String title, String description,
			String status, LocalDateTime startTime, LocalDateTime endTime, int questionAmount);

	// 刪除問卷
	public QuestionnaireResponse deleteQuestionnaire(Integer serialNumber);
}
