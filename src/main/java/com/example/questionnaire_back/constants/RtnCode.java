package com.example.questionnaire_back.constants;

public enum RtnCode {
	
	SUCCESS("200", "Success!"), 
	CANNOT_EMPTY("400", "Input is empty!"), 
	INCORRECT("401", " Incorrect requests!"),
	TEST1_ERROR("401", " Test1 is error!"), 
	TEST2_ERROR("401", " Test2 is error!"),
	TEST3_ERROR("401", " Test3 is error!"), 
	TEST4_ERROR("401", " Test4 is error!"),
	TEST5_ERROR("401", " Test5 is error!"), 
	TEST6_ERROR("401", " Test6 is error!"),
	TEST7_ERROR("401", " Test7 is error!"), 
	NOT_FOUND("404", "Not found!"),
	ALREADY_EXISTED("409", "Has already existed!"), 
	PATTERNISNOTMATCH("422", "Pattern is not match!");

	private String code;
	private String message;

	private RtnCode(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
