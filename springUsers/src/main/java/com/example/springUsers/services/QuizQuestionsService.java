package com.example.springUsers.services;

import java.util.Set;

import com.example.springUsers.entities.quiz.Question;
import com.example.springUsers.entities.quiz.Quiz;

public interface QuizQuestionsService {

	public Question addQuestion(Question question);
	
	public Question updateQuestion(Question question);
	
	public Set<Question> getQuestion();
	
	public Question getQuestion(Long questionId);
	
	public Set<Question> getQuestionOfQuiz(Quiz quiz);
	
	public void deleteQuestion(Long questionId);
	
	public Question get(Long questionsId);
}
