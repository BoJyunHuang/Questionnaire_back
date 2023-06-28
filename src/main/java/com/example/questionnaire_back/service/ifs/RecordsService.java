package com.example.questionnaire_back.service.ifs;

import com.example.questionnaire_back.vo.RecordsResponse;

public interface RecordsService {

	// 新增使用者回答
	public RecordsResponse addRecords(String name, String phoneNumber, String email, int age, int qnNumber,
			String answers);

	// 查詢使用者填答
	public RecordsResponse findRecords(int qnNumber);
}
