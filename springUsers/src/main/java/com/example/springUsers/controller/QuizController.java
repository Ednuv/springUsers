package com.example.springUsers.controller;
import java.util.List;

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
import com.example.springUsers.entities.quiz.Quiz;
import com.example.springUsers.services.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
		Quiz quiz1= this.quizService.addQuiz(quiz);
		return ResponseEntity.ok(quiz1);
	}
 
	@GetMapping("/{quizId}")
	public Quiz getQuiz(@PathVariable("quizId") Long quizId) {
		
	   return this.quizService.getQuiz(quizId);
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getQuizzes(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	@PutMapping("/")
	public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
		return  ResponseEntity.ok(this.quizService.updateQuiz(quiz));
	}
	
	@DeleteMapping("/{quizId}")
	public void deleteQuiz(@PathVariable("quizId") Long quizId)
	{
		this.quizService.deleteQuiz(quizId);
	}
	
	@GetMapping("/quizcategory/{cid}")
	public List<Quiz> getQuizzesOfCategory(@PathVariable("cid") Long cid){
		Category category = new Category();
		category.setCid(cid);
		return this.quizService.getQuizzesOfCategory(category);
	}
	
}
