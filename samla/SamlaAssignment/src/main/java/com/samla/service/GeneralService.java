package com.samla.service;

import java.util.List;

import com.samla.model.AnswerDTO;
import com.samla.model.QuestionDTO;
import com.samla.model.Task;
import com.samla.model.ValidateResponse;

public interface GeneralService {
	public List<Task> random();
	public Task save(Task task);
	public QuestionDTO getRandom();
	public ValidateResponse validate(AnswerDTO answerdto);
}
