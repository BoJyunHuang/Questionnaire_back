package com.example.questionnaire_back.service.ifs;

import com.example.questionnaire_back.vo.QuestionnaireRequest;
import com.example.questionnaire_back.vo.QuestionnaireResponse;

public interface QuestionnaireService {

	// 顯示所有問卷
	public QuestionnaireResponse showAllQuestionnaires();
	
	// 新增問卷
	public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest request);
	
	// 修改問卷
	public QuestionnaireResponse reviseQuestionnaire(QuestionnaireRequest request);
	
	// 刪除問卷
	public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest request);
}
