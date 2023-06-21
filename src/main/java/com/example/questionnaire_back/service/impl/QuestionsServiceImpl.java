package com.example.questionnaire_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionnaire_back.repository.QuestionsDao;
import com.example.questionnaire_back.service.ifs.QuestionsService;
import com.example.questionnaire_back.vo.QuestionsRequest;
import com.example.questionnaire_back.vo.QuestionsResponse;

@Service
public class QuestionsServiceImpl implements QuestionsService{

	@Autowired
	private QuestionsDao questionsDao;
	
	@Override
	public QuestionsResponse addQuestions(QuestionsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionsResponse showQuestions(QuestionsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionsResponse reviseQuestions(QuestionsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionsResponse deleteQuestions(QuestionsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
