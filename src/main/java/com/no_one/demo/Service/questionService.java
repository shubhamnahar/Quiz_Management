package com.no_one.demo.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.no_one.demo.dao.QuestionDao;
import com.no_one.demo.model.question;

@Service
public class questionService {

//	private static final Logger logger = LoggerFactory.getLogger(questionService.class);

	@Autowired
	private QuestionDao questiondao;

	public ResponseEntity<List<question>> GetAllQuestions() {
		try {
			return new ResponseEntity<>(questiondao.findAll(), HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

//		List<question> questions = questiondao.findAll();
//        logger.info("Fetched {} questions", questions.size());
//        for (question question : questions) {
//            logger.info("Question ID: {}, Title: {}", question.getId(), question.getQuestionTitle());
//        }
//        return questions;
	}

	public ResponseEntity<List<question>> GetCategory(String category) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Inside Get Category in Service Layer--" + category);
			return new ResponseEntity<>(questiondao.findAllBycategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(question questions) {

		try {
			 questiondao.save(questions);
			return new ResponseEntity<>("Success", HttpStatus.OK);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return new ResponseEntity<>(new String(), HttpStatus.BAD_REQUEST);

	}

	public ResponseEntity<List<String>> GetCategoriesDropDown() {
		System.out.println("Inside service layer");
		
		return new ResponseEntity<>(questiondao.findCategory(),HttpStatus.OK);
//		return null;
	}

}
