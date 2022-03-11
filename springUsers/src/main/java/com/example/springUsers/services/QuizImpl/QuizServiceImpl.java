package com.example.springUsers.services.QuizImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.QuizDao;
import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.entities.quiz.Quiz;
import com.example.springUsers.services.QuizService;

@Service
public class QuizServiceImpl implements QuizService {
	
	@Autowired
	private QuizDao quizDao;

	@Override
	public Quiz addQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizDao.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizDao.save(quiz);
	}

	@Override
	public Quiz getQuiz(Long quizId) {
		// TODO Auto-generated method stub
		return this.quizDao.findById(quizId).get();
	}

	@Override
	public Set<Quiz> getQuizzes() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizDao.findAll());
	}

	@Override
	public void deleteQuiz(Long quizId) {
		// TODO Auto-generated method stub
		Quiz quiz = new Quiz();
		quiz.setqId(quizId);
		this.quizDao.delete(quiz);
		
	}

	@Override
	public List<Quiz> getQuizzesOfCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizDao.findBycategory(category);
	}

}
