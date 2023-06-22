package com.example.questionnaire_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.repository.QuestionnaireDao;
import com.example.questionnaire_back.service.ifs.QuestionnaireService;
import com.example.questionnaire_back.vo.QuestionnaireRequest;
import com.example.questionnaire_back.vo.QuestionnaireResponse;

@Service
public class QuestionnaireServiceImpl implements QuestionnaireService {

	@Autowired
	private QuestionnaireDao questionnaireDao;

	@Override
	public QuestionnaireResponse showAllQuestionnaires() {
		return new QuestionnaireResponse(RtnCode.SUCCESS.getMessage(), questionnaireDao.findAll());
	}

	@Override
	public QuestionnaireResponse addQuestionnaire(QuestionnaireRequest request) {
		if (request == null || !StringUtils.hasText(request.getTitle())
				|| !StringUtils.hasText(request.getDescription()) || request.getStartTime() == null
				|| request.getEndTime() == null || request.getEndTime().isBefore(request.getStartTime())
				|| request.getQuestionAmount() < 0) {
			return new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		return questionnaireDao.insertQuestionnaire(request.getTitle(), request.getDescription(), "尚未開始",
				request.getStartTime(), request.getEndTime(), request.getQuestionAmount()) == 0
						? new QuestionnaireResponse(RtnCode.INCORRECT.getMessage())
						: new QuestionnaireResponse(RtnCode.SUCCESS.getMessage());
	}

	@Override
	public QuestionnaireResponse reviseQuestionnaire(QuestionnaireRequest request) {
		return request != null && request.getSerialNumber() != null
				? (questionnaireDao.updateQuestionnaire(request.getSerialNumber(), request.getTitle(),
						request.getDescription(), request.getStatus(), request.getStartTime(), request.getEndTime(),
						request.getQuestionAmount()) == 0 ? new QuestionnaireResponse(RtnCode.INCORRECT.getMessage())
								: new QuestionnaireResponse(RtnCode.SUCCESS.getMessage()))
				: new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
	}

	@Override
	public QuestionnaireResponse deleteQuestionnaire(QuestionnaireRequest request) {
		return request != null && request.getSerialNumber() != null
				? (questionnaireDao.deleteQuestionnaire(request.getSerialNumber()) == 0
						? new QuestionnaireResponse(RtnCode.INCORRECT.getMessage())
						: new QuestionnaireResponse(RtnCode.SUCCESS.getMessage()))
				: new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
	}
}
