package com.example.questionnaire_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.repository.QuestionsDao;
import com.example.questionnaire_back.service.ifs.QuestionsService;
import com.example.questionnaire_back.vo.QuestionsRequest;
import com.example.questionnaire_back.vo.QuestionsResponse;

@Service
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private QuestionsDao questionsDao;

	@Override
	public QuestionsResponse addQuestions(QuestionsRequest request) {
		return request == null || CollectionUtils.isEmpty(request.getQuestionsList())
				? new QuestionsResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: new QuestionsResponse(RtnCode.SUCCESS.getMessage(), questionsDao.saveAll(request.getQuestionsList()));
	}

	@Override
	public QuestionsResponse showQuestions(QuestionsRequest request) {
		return request == null ? new QuestionsResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: new QuestionsResponse(RtnCode.SUCCESS.getMessage(),
						questionsDao.searchQuestions(request.getQnNumber()));
	}

	@Override
	public QuestionsResponse deleteQuestions(QuestionsRequest request) {
		return request == null || CollectionUtils.isEmpty(request.getSerialNumberList())
				? new QuestionsResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: (questionsDao.deleteQuestions(request.getSerialNumberList()) == request.getSerialNumberList().size()
						? new QuestionsResponse(RtnCode.INCORRECT.getMessage())
						: new QuestionsResponse(RtnCode.SUCCESS.getMessage()));
	}

}
