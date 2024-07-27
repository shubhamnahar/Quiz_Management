package com.no_one.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.no_one.demo.Service.questionService;
import com.no_one.demo.model.question;

@RestController
@RequestMapping("question")
public class QuestionController {

	@Autowired
	questionService questionservice;
	
	@GetMapping("/AllQuestions")
	public ResponseEntity<List<question>> GetAllQuestions() {
//		int i=9/0;
		return questionservice.GetAllQuestions();
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<question>> GetCategory(@PathVariable String category){
//		System.out.println("Heyyy  category------"+category);
		return questionservice.GetCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> addQuestion(@RequestBody question question) {
		System.out.println("question:="+question);
		return questionservice.addQuestion(question);
	}
	
	@GetMapping("categoriesValues")
	public ResponseEntity<List<String>> GetCategoriesDropDown(){
		return questionservice.GetCategoriesDropDown();
	}
	
	
	
	
}
