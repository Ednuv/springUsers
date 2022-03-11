package com.example.springUsers.services;

import java.util.Set;

import com.example.springUsers.entities.quiz.Category;

public interface QuizCategoryService {
	
	public Category addCategory(Category category);
	
	public Category updateCategory(Category category);
	
	public Set<Category> getCategories();
	
	public Category getcategory(Long categoryId);
	
	public void deleteCategory(Long categoryId);
}
