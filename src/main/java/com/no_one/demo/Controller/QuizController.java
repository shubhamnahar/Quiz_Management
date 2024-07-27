package com.no_one.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import com.no_one.demo.Service.QuizService;
import com.no_one.demo.model.QuestionWrapper;
import com.no_one.demo.model.Response;
import com.no_one.demo.model.question;

@RestController
@RequestMapping("quiz")
public class QuizController {

	@Autowired
	QuizService quizservice;
	
	@PostMapping("create")
	public ResponseEntity<Integer> createQuiz(@RequestParam String category ,@RequestParam int noOfQues, @RequestParam String title){
//		return new ResponseEntity<>("qwertyuiod",HttpStatus.OK);
		System.out.println("category:"+category+" noOfQues:--"+noOfQues+" title:"+title);
		return quizservice.createQuiz(category,noOfQues,title);
		
	}
	
	@GetMapping("/getQuiz/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
		System.out.println("Id in getQuizQuestions:::::"+id);
		return quizservice.getQuizQuestion(id);
	}
	
	@PostMapping("sumbit/{id}")
	public ResponseEntity<Integer> getScore(@PathVariable Integer id, @RequestBody List<Response> response){
		
		
		
		return quizservice.getScore(id,response);
	}
}
