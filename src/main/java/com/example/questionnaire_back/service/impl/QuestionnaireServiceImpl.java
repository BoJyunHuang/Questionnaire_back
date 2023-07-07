package com.example.questionnaire_back.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.entity.Questionnaire;
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
	public QuestionnaireResponse renewQuestionnaire(Integer serialNumber, String title, String description,
			LocalDate startDate, LocalDate endDate) {
		if (!StringUtils.hasText(title) || !StringUtils.hasText(description) || startDate == null || endDate == null
				|| startDate.isBefore(LocalDate.now()) || endDate.isBefore(startDate)) {
			return new QuestionnaireResponse(RtnCode.INCORRECT.getMessage());
		}
		Questionnaire qn = new Questionnaire(serialNumber == null ? 0 : serialNumber, title, description, startDate,
				endDate);
		return new QuestionnaireResponse(RtnCode.SUCCESS.getMessage(), questionnaireDao.save(qn));
	}

	@Override
	public QuestionnaireResponse deleteQuestionnaire(List<Integer> serialNumberList) {
		return CollectionUtils.isEmpty(serialNumberList) ? new QuestionnaireResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: (questionnaireDao.deleteQuestionnaire(serialNumberList) == 0
						? new QuestionnaireResponse(RtnCode.INCORRECT.getMessage())
						: new QuestionnaireResponse(RtnCode.SUCCESS.getMessage()));

	}
}
