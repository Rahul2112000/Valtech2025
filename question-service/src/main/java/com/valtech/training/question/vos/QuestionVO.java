package com.valtech.training.question.vos;

import com.valtech.training.question.entities.Question;

public record QuestionVO ( long id,String question,String option1,String option2,
	String option3,String option4,String topic,String correct) {
	
	public Question to() {
		return new Question(id,question,option1,option2,option3,option4,topic,correct);
	}
	
	public static QuestionVO from(Question ques) {
		return new QuestionVO(ques.getId(),ques.getQuestion(),ques.getOption1(),ques.getOption2(),
				ques.getOption3(),ques.getOption4(),ques.getTopic(),ques.getCorrect());
	}

	public void updateTo(Question q) {
		q.setQuestion(question);
		q.setOption1(option1);
		q.setOption2(option2);
		q.setOption3(option3);
		q.setOption4(option4);
		q.setTopic(topic);
		
		
	}

}
