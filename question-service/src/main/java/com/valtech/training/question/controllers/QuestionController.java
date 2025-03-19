package com.valtech.training.question.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.valtech.training.question.services.QuestionService;
import com.valtech.training.question.vos.QuestionVO;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/add")
	public QuestionVO addQuestion(@RequestBody QuestionVO question) {
		return questionService.saveOrUpdateQuestion(question);
	}
	
	@GetMapping("/")
	public List<QuestionVO> getAllQuestion() {
		return questionService.getAllQuestion();
	}
	
	@GetMapping("/{id}")
	public QuestionVO getQuestion(@PathVariable("id") long id) {
		return questionService.getQuestion(id);
	}
	
	@PutMapping("/{id}")
		public QuestionVO updateQuestion(@PathVariable("id") long id,@RequestBody QuestionVO vo) {
			return questionService.update(vo, id);
		}
	
	
}
