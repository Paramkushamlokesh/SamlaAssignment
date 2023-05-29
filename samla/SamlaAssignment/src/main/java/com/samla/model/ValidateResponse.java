package com.samla.model;

import lombok.Data;

@Data
public class ValidateResponse {
	
	boolean status;
	String correct_answer;
	QuestionDTO question_dto;

}
