package com.example.springUsers.services;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.entities.quiz.Quiz;

public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	
	public Quiz updateQuiz(Quiz quiz);
	
	public Quiz getQuiz(Long quizId);
	
	public Set<Quiz> getQuizzes();
	
	public void deleteQuiz(Long quizId);

	public List<Quiz> getQuizzesOfCategory(Category category);
}
