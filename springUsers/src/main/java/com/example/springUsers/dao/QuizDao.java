package com.example.springUsers.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.entities.quiz.Quiz;

public interface QuizDao extends JpaRepository<Quiz,Long>{
	
  public List<Quiz> findBycategory(Category category);
}
