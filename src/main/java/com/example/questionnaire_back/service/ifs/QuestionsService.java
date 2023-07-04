package com.example.questionnaire_back.service.ifs;

import java.util.List;

import com.example.questionnaire_back.entity.Questions;
import com.example.questionnaire_back.vo.QuestionsResponse;

public interface QuestionsService {

	// 新增問題集
	public QuestionsResponse addQuestions(List<Questions> questionsList);

	// 修改問題集
	public QuestionsResponse reviseQuestion(Integer serialNumber, String question, String kind, boolean isRequired,
			String selections);

	// 顯示該問卷問題集
	public QuestionsResponse showQuestions(int qnNumber);

	// 刪除問題集
	public QuestionsResponse deleteQuestions(List<Integer> serialNumberList);

	// 刪除問卷問題集
	public QuestionsResponse deleteQnQuestions(int qnNumber);
}
