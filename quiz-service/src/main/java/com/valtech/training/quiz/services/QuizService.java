package com.valtech.training.quiz.services;

import java.util.List;

import com.valtech.training.quiz.vos.QuestionVO;
import com.valtech.training.quiz.vos.QuizMasterVO;
import com.valtech.training.quiz.vos.QuizVO;

public interface QuizService {

	QuizVO generateQuiz(int count, String topic, String difficultyLevel);

	long calculateResult(long quizId, List<String> answers);

	List<QuizVO> getAllQuizes();

	List<QuestionVO> getSelectedQuestions(long quizId);

	QuizMasterVO getQuizMaster(long quizId);

	List<QuizMasterVO> getAllQuizMasters();

	QuizMasterVO createQuizMaster(QuizMasterVO vo);

}