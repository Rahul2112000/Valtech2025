package com.valetch.training.first.services;

import java.util.List;

import com.valetch.training.first.entites.Question;

public interface QuestionService {
	
	

	Question saveQuestion(Question question);

	Question updateQuestion(Question question);

	void deleteQuestion(Question question);

	Question getQuestion(long id);
	long count();

	List<Question> getAllquestion();
	
	List<Question> findAllByTopic(String topic);

	long countByTopic(String topic);

	long countByTopicAndQuestionTextContaining(String topic, String keyword);

	long countByTopicAndQuestionTextContainingIgnoreCase(String topic, String keyword);
	
	

	List<Question> findAllByTopic(String topic, int page, int size);


}