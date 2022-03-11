package com.example.springUsers.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.mapping.Collection;
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

import com.example.springUsers.entities.quiz.Question;
import com.example.springUsers.entities.quiz.Quiz;
import com.example.springUsers.services.QuizQuestionsService;
import com.example.springUsers.services.QuizService;


@RestController
@RequestMapping("/quizquestion")
@CrossOrigin("*")
public class QuizQuestionController {
	
	@Autowired
	private QuizQuestionsService quizQuestionService;
	
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/")
	public ResponseEntity<Question> addQuizQuestion(@RequestBody Question question){
		Question question1= this.quizQuestionService.addQuestion(question);
		return ResponseEntity.ok(question1);
	}
	
	@GetMapping("/quiz/{qId}")
	public ResponseEntity<?> getQuizQuestion(@PathVariable("qId") Long qId) {
		
		Quiz quiz = this.quizService.getQuiz(qId);
		Set<Question> questions= quiz.getQuestions();
		List<Question> list = new ArrayList<Question>(questions);
		if(list.size()>Integer.parseInt(quiz.getNumberOfQuestion())) {
			list = list.subList(0, Integer.parseInt(quiz.getNumberOfQuestion()+1));
		}
		Collections.shuffle(list);
		System.out.print(list);
		return ResponseEntity.ok(list);
	}
    
	@GetMapping("/{quesId}")
	public Question getQuizzesQuestion(@PathVariable("quesId") Long quesId){
		
		return this.quizQuestionService.getQuestion(quesId);
		
	}
	
	@PutMapping("/")
	public ResponseEntity<Question> updateQuizQuestion(@RequestBody Question question) {
		return  ResponseEntity.ok(this.quizQuestionService.updateQuestion(question));
	}
	
	@DeleteMapping("/{questionId}")
	public void deleteQuizQuestion(@PathVariable("questionId") Long questionId)
	{
		this.quizQuestionService.deleteQuestion(questionId);
	}
	
	@PostMapping("/eval-quiz")
	public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions){
		 double marksGot=0;
		 int correctAnswers=0;
		 int attempted=0;
		for(Question q:questions){
			Question question = this.quizQuestionService.get(q.getQuesId());
			if(question.getAnswer().equals(q.getGivenAnswer())) {
				correctAnswers++;	
				 double marksSingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size();
				 marksGot += marksSingle;
			}
			if(q.getGivenAnswer()!=null){
				attempted++;
			}
		};
		Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attempted",attempted);
		return ResponseEntity.ok(map);
	}

}
