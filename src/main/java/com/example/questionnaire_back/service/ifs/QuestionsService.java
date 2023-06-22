package com.example.questionnaire_back.service.ifs;

import com.example.questionnaire_back.vo.QuestionsRequest;
import com.example.questionnaire_back.vo.QuestionsResponse;

public interface QuestionsService {
	
	// 新增/修改問題集
	public QuestionsResponse addQuestions(QuestionsRequest request);
	
	// 顯示該問卷問題集
	public QuestionsResponse showQuestions(QuestionsRequest request);
	
	// 刪除問題集
	public QuestionsResponse deleteQuestions(QuestionsRequest request);
}
