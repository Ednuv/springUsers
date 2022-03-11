package com.example.springUsers.services.QuizImpl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springUsers.dao.QuizCategoryDao;
import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.services.QuizCategoryService;

@Service
public class QuizCategoryServiceImpl implements QuizCategoryService {
	
	@Autowired
	private QuizCategoryDao quizCategoryDao;

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizCategoryDao.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		// TODO Auto-generated method stub
		return this.quizCategoryDao.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		// TODO Auto-generated method stub
		return new LinkedHashSet<>(this.quizCategoryDao.findAll());
	}

	@Override
	public Category getcategory(Long categoryId) {
		// TODO Auto-generated method stub
		return this.quizCategoryDao.findById(categoryId).get();
	}

	@Override
	public void deleteCategory(Long categoryId) {
		// TODO Auto-generated method stub
		Category category = new Category();
		category.setCid(categoryId);
		this.quizCategoryDao.delete(category);
		
	}

}
