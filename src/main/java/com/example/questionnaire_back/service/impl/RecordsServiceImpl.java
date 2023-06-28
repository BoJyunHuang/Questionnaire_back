package com.example.questionnaire_back.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.repository.RecordsDao;
import com.example.questionnaire_back.service.ifs.RecordsService;
import com.example.questionnaire_back.vo.RecordsResponse;

@Service
public class RecordsServiceImpl implements RecordsService {

	@Autowired
	private RecordsDao recordsDao;

	@Override
	public RecordsResponse addRecords(String name, String phoneNumber, String email, int age, int qnNumber,
			String answers) {
		if (!StringUtils.hasText(name) || !StringUtils.hasText(phoneNumber) || !StringUtils.hasText(email) || age <= 0
				|| qnNumber <= 0 || !StringUtils.hasText(answers)) {
			return new RecordsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		return recordsDao.insertRecords(name, phoneNumber, email, age, qnNumber, LocalDateTime.now(), answers) == 0
				? new RecordsResponse(RtnCode.INCORRECT.getMessage())
				: new RecordsResponse(RtnCode.SUCCESS.getMessage());
	}

	@Override
	public RecordsResponse findRecords(int qnNumber) {
		return qnNumber <= 0 ? new RecordsResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: new RecordsResponse(RtnCode.SUCCESS.getMessage(), recordsDao.searchRecords(qnNumber));
	}

}
