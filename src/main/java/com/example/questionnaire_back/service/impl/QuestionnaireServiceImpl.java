package com.example.questionnaire_back.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.repository.QuestionnaireDao;
import com.example.questionnaire_back.service.ifs.QuestionnaireService;
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
	public QuestionnaireResponse addQuestionnaire(String title, String description, LocalDateTime startTime,
			LocalDateTime endTime) {
		if (!StringUtils.hasText(title) || !StringUtils.hasText(description) || startTime == null
				|| startTime.isBefore(LocalDateTime.now())) {
			return new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		return questionnaireDao.insertQuestionnaire(title, description, "尚未開始", startTime, endTime) == 0
				? new QuestionnaireResponse(RtnCode.INCORRECT.getMessage())
				: new QuestionnaireResponse(RtnCode.SUCCESS.getMessage());
	}

	@Override
	public QuestionnaireResponse reviseQuestionnaire(Integer serialNumber, String title, String description,
			String status, LocalDateTime startTime, LocalDateTime endTime, int questionAmount) {
		return serialNumber != null
				? (questionnaireDao.updateQuestionnaire(serialNumber, title, description, status, startTime, endTime,
						questionAmount) == 0 ? new QuestionnaireResponse(RtnCode.INCORRECT.getMessage())
								: new QuestionnaireResponse(RtnCode.SUCCESS.getMessage()))
				: new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
	}

	@Override
	public QuestionnaireResponse deleteQuestionnaire(Integer serialNumber) {
		return serialNumber != null
				? (questionnaireDao.deleteQuestionnaire(serialNumber) == 0
						? new QuestionnaireResponse(RtnCode.INCORRECT.getMessage())
						: new QuestionnaireResponse(RtnCode.SUCCESS.getMessage()))
				: new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage());
	}
}
