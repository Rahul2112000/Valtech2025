package com.valtech.training.question.services;

import java.util.List;

import com.valtech.training.question.vos.QuestionVO;

public interface QuestionService {

	QuestionVO saveOrUpdateQuestion(QuestionVO vo);

	//List<QuestionVO> getRandomQuestionByTopic(String topic, int count);

	QuestionVO getQuestion(long id);

	List<QuestionVO> getAllQuestion();

	QuestionVO update(QuestionVO vo, long id);

}