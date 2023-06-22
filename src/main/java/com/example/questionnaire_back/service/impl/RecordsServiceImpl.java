package com.example.questionnaire_back.service.impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.questionnaire_back.constants.RtnCode;
import com.example.questionnaire_back.repository.RecordsDao;
import com.example.questionnaire_back.service.ifs.RecordsService;
import com.example.questionnaire_back.vo.RecordsRequest;
import com.example.questionnaire_back.vo.RecordsResponse;

@Service
public class RecordsServiceImpl implements RecordsService {

	@Autowired
	private RecordsDao recordsDao;

	@Override
	public RecordsResponse addRecords(RecordsRequest request) {
		if (request == null || StringUtils.hasText(request.getName()) || StringUtils.hasText(request.getPhoneNumber())
				|| StringUtils.hasText(request.getEmail()) || request.getAge() < 0 || request.getQnNumber() < 0
				|| StringUtils.hasText(request.getAnswers())) {
			return new RecordsResponse(RtnCode.CANNOT_EMPTY.getMessage());
		}
		return recordsDao.insertRecords(request.getName(), request.getPhoneNumber(), request.getEmail(),
				request.getAge(), request.getQnNumber(), LocalDateTime.now(), request.getAnswers()) == 0
						? new RecordsResponse(RtnCode.INCORRECT.getMessage())
						: new RecordsResponse(RtnCode.SUCCESS.getMessage());
	}

	@Override
	public RecordsResponse findRecords(RecordsRequest request) {
		return request == null || request.getQnNumber() < 0 ? new RecordsResponse(RtnCode.CANNOT_EMPTY.getMessage())
				: new RecordsResponse(RtnCode.SUCCESS.getMessage(), recordsDao.searchRecords(request.getQnNumber()));
	}

}
