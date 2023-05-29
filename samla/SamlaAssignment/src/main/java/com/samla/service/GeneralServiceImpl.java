package com.samla.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.samla.model.AnswerDTO;
import com.samla.model.QuestionDTO;
import com.samla.model.Task;
import com.samla.model.ValidateResponse;
import com.samla.repository.TaskRepo;

@Service
public class GeneralServiceImpl implements GeneralService {
	@Autowired
	RestTemplate resttemplate;
	@Autowired
	TaskRepo tr;
	
	@Override
	public List<Task> random(){
		List<Task> li=new ArrayList<>();
		for(int i=0;i<5;i++) {
			Task[] task=resttemplate.getForObject("https://jservice.io/api/random",Task[].class);
			li.add(tr.save(task[0]));
		}
		if(li.isEmpty())throw new RuntimeException("error can't fetch details");
		return li;
	}
	
	@Override
	public Task save(Task task) {
		if(task==null)throw new RuntimeException("task can not be null");
		return tr.save(task);
	}
	
	@Override
	public QuestionDTO getRandom() {
		QuestionDTO o=new QuestionDTO();
		Task task=tr.getRandomQuestion();
		o.setId(task.getId());
		o.setQuestion(task.getQuestion());
		return o;
	}
	
	@Override
	public ValidateResponse validate(AnswerDTO answerdto) {
		Task task=tr.findById(answerdto.getId()).orElseThrow(()->new RuntimeException("provide correcct question_id"));
		ValidateResponse validateresponse=new ValidateResponse();
		validateresponse.setStatus(answerdto.getAnswer().equals(task.getAnswer()));
		validateresponse.setCorrect_answer(task.getAnswer());
		validateresponse.setQuestion_dto(getRandom());
		return validateresponse;
	}

}
