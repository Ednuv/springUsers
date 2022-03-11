package com.example.springUsers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springUsers.entities.quiz.Category;
import com.example.springUsers.services.QuizCategoryService;

@RestController
@RequestMapping("/quizcategory")
@CrossOrigin("*")
public class QuizCategoryController {
	
	@Autowired
	private QuizCategoryService quizCategoryService;
    
	@PostMapping("/")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category category1= this.quizCategoryService.addCategory(category);
		return ResponseEntity.ok(category1);
	}
	
	@GetMapping("/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") Long categoryId) {
		
	   return this.quizCategoryService.getcategory(categoryId);	
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.quizCategoryService.getCategories());
	}
	
	@PutMapping("/")
	public Category updateCategory(@RequestBody Category category) {
		return this.quizCategoryService.updateCategory(category);
	}
	
	@DeleteMapping("/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId") Long categoryId)
	{
		this.quizCategoryService.deleteCategory(categoryId);
	}
}
