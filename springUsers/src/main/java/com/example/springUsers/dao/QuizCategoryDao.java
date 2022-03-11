package com.example.springUsers.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springUsers.entities.quiz.Category;

public interface QuizCategoryDao extends JpaRepository<Category,Long>{

}
