package com.valetch.training.first;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valetch.training.first.entites.Question;
import com.valetch.training.first.services.QuestionService;

@SpringBootTest
class FirstApplicationTests {

	@Autowired
	private Arithmetic arithmetic;

	@Autowired
	private SimpleInterest simpleInterest;

	@Autowired
	private QuestionService questionService;

	@Test
	void testArithmetic() {

		assertEquals(10, arithmetic.add(4, 6));
		assertEquals(200, simpleInterest.compute(200, 5, 20));
	}
	
	@Test
	void questionService() {
//		assertEquals(5, questionService.findAllByTopic("Gk").size());
//		assertEquals(6, questionService.findAllByTopic("JAVA").size());

		assertEquals(5, questionService.countByTopic("Gk"));
		assertEquals(6, questionService.countByTopic("JAVA"));
		assertEquals(2, questionService.countByTopicAndQuestionTextContaining("JAVA","Exception"));
		assertEquals(3, questionService.countByTopicAndQuestionTextContainingIgnoreCase("JAVA","Interface"));
		assertEquals(4, questionService.findAllByTopic("Gk",0,4).size());
		assertEquals(1, questionService.findAllByTopic("Gk",1,4).size());


	}
	

	@Test
	@BeforeEach
	void initData() {
		//System.out.println("Question Service Class Name=" + questionService.getClass().getName());
		
		long count = questionService.count();
		if(count!=0) return;
		Question q = questionService
				.saveQuestion(new Question("What is the color of sky?", "Red", "Blue", "Green", "Black", "Blue", "Gk"));
		questionService
		.saveQuestion(new Question("What is the color of Mars?", "Red", "Blue", "Green", "Black", "Red", "Gk"));
		
		questionService
		.saveQuestion(new Question("What is the color of Moon?", "Red", "Blue", "Green", "White", "White", "Gk"));
		
		questionService
		.saveQuestion(new Question("What is the color of Saturn?", "Red", "Blue", "Green", "Black", "Black", "Gk"));
		
		questionService
		.saveQuestion(new Question("What is the color of Venus?", "Red", "Yellow", "Green", "Black", "Yellow", "Gk"));
		
		//java question
		
		questionService
		.saveQuestion(new Question("What is the super class of Exception?", "Object", "Exception", "Throwable", "Error", "Throwable", "JAVA"));

		questionService
		.saveQuestion(new Question("What class is used to create Dynamic String?", "String", "DynamicString", "Builder", "StringBuilder", "StringBuilder", "JAVA"));

		questionService
		.saveQuestion(new Question("How many method are in marker Interface?", "One", "Two", "Zero", "Many", "Zero", "JAVA"));

		questionService
		.saveQuestion(new Question("How many method are in Functional Interface?", "One", "Two", "Zero", "Many", "One", "JAVA"));

		questionService
		.saveQuestion(new Question("Can an Interface have private method?", "Yes", "No", "Both", "none", "Yes", "JAVA"));

		questionService
		.saveQuestion(new Question("Which subclass of Exception is not checked by the complier?", "Exception", "Error", "Runtime", "Compiletime", "Runtime", "JAVA"));


//		assertTrue(q.getId() > 0);
//		assertEquals(count + 1, questionService.count());
	}

}
