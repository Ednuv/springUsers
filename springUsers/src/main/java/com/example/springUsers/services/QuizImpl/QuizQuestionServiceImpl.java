package com.example.springUsers.services.QuizImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.QuizQuestionDao;
import com.example.springUsers.entities.quiz.Question;
import com.example.springUsers.entities.quiz.Quiz;
import com.example.springUsers.services.QuizQuestionsService;

@Service
public class QuizQuestionServiceImpl implements QuizQuestionsService {
	
	@Autowired
	private QuizQuestionDao quizQuestionDao;

	@Override
	public Question addQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.quizQuestionDao.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		// TODO Auto-generated method stub
		return this.quizQuestionDao.save(question);
	}

	@Override
	public Set<Question> getQuestion() {
		// TODO Auto-generated method stub
		return new HashSet<>(this.quizQuestionDao.findAll());
	}

	@Override
	public Question getQuestion(Long questionId) {
		// TODO Auto-generated method stub
		return this.quizQuestionDao.findById(questionId).get();
	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		return this.quizQuestionDao.findByQuiz(quiz);
	}

	@Override
	public void deleteQuestion(Long questionId) {
		// TODO Auto-generated method stub
		Question question = new Question();
		question.setQuesId(questionId);
		this.quizQuestionDao.delete(question);
		
	}

	@Override
	public Question get(Long questionsId) {
		// TODO Auto-generated method stub
		return this.quizQuestionDao.getById(questionsId);
	}

}
