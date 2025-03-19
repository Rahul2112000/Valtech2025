package com.valtech.training.question.services;

import java.util.List;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.question.entities.Question;
import com.valtech.training.question.repo.QuestionRepo;
import com.valtech.training.question.vos.QuestionVO;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Override
	public QuestionVO saveOrUpdateQuestion(QuestionVO vo) {
		Question q=vo.to();
		q=questionRepo.save(q);
		return QuestionVO.from(q);
	}
	
//	@Override
//	public List<QuestionVO> getRandomQuestionByTopic(String topic,int count){
//		List<Question> q=questionRepo.findRandomQuestionByTopic(topic,count);
//		return q.stream().map(qs->QuestionVO.from(qs)).collect(Collectors.toList());
//	}

	@Override
	public QuestionVO getQuestion(long id) {
		return QuestionVO.from(questionRepo.getReferenceById(id));
	}
	
	@Override
	public List<QuestionVO> getAllQuestion(){
		return questionRepo.findAll().stream().map(l->QuestionVO.from(l)).collect(Collectors.toList());
	}
	
	@Override
	public QuestionVO update(QuestionVO vo,long id) {
		Question que=questionRepo.getReferenceById(id);
		vo.updateTo(que);
		que=questionRepo.save(que);
		return QuestionVO.from(que);
	}
}
