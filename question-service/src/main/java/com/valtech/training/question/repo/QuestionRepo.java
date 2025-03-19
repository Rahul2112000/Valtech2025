package com.valtech.training.question.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.question.entities.Question;

public interface QuestionRepo extends JpaRepository<Question, Long> {

	//List<Question> findRandomQuestionByTopic(String topic, int count);

}
