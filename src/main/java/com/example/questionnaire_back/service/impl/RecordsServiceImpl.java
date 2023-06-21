package com.example.questionnaire_back.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.questionnaire_back.repository.RecordsDao;
import com.example.questionnaire_back.service.ifs.RecordsService;
import com.example.questionnaire_back.vo.RecordsRequest;
import com.example.questionnaire_back.vo.RecordsResponse;

@Service
public class RecordsServiceImpl implements RecordsService{
	
	@Autowired
	private RecordsDao recordsDao;

	@Override
	public RecordsResponse addRecords(RecordsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecordsResponse findRecords(RecordsRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
