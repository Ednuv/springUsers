package com.example.springUsers.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springUsers.entities.quiz.Question;
import com.example.springUsers.entities.quiz.Quiz;

public interface QuizQuestionDao extends JpaRepository<Question,Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
