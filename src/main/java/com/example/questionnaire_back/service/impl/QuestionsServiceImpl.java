package com.example.questionnaire_back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.entity.Questions;
import com.example.questionnaire_back.repository.QuestionsDao;
import com.example.questionnaire_back.service.ifs.QuestionsService;
import com.example.questionnaire_back.vo.QuestionsResponse;

@Service
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private QuestionsDao questionsDao;

	@Override
	public QuestionsResponse addQuestions(List<Questions> questionsList) {
		return CollectionUtils.isEmpty(questionsList) ? new QuestionsResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: new QuestionsResponse(RtnCode.SUCCESS.getMessage(), questionsDao.saveAll(questionsList));
	}

	@Override
	public QuestionsResponse showQuestions(int qnNumber) {
		return qnNumber <= 0 ? new QuestionsResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: new QuestionsResponse(RtnCode.SUCCESS.getMessage(), questionsDao.searchQuestions(qnNumber));
	}

	@Override
	public QuestionsResponse deleteQuestions(List<Integer> serialNumberList, int qnNumber) {
		return questionsDao.deleteQuestions(CollectionUtils.isEmpty(serialNumberList) ? null : serialNumberList,
				qnNumber < 1 ? 0 : qnNumber) == 0 ? new QuestionsResponse(RtnCode.INCORRECT.getMessage())
						: new QuestionsResponse(RtnCode.SUCCESS.getMessage());
	}

}
