package com.no_one.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.no_one.demo.dao.QuestionDao;
import com.no_one.demo.dao.QuizDao;
import com.no_one.demo.model.QuestionWrapper;
import com.no_one.demo.model.Quiz;
import com.no_one.demo.model.Response;
import com.no_one.demo.model.question;

@Service
public class QuizService {

	@Autowired
	QuizDao quizdao;

	@Autowired
	QuestionDao questiondao;
	
//	@Autowired
//	QuestionWrapper questionwrapper;
	
	public ResponseEntity<Integer> createQuiz(String category, int noOfQues, String title) {
		// TODO Auto-generated method stub
		try {
		Quiz quiz = new Quiz();
		List<question> questions=questiondao.findRandomQuestionByCategory(category,noOfQues);
		
		
		quiz.setTitle(title);
		quiz.setQuestions(questions);
//		System.out.println("Question at Quiz Service---------"+questions);
		quizdao.save(quiz);
		List<Integer> s=quizdao.findIdOrderById();
//		System.out.println("Inside CreateQuiz::::---------------------------------"+s.toString());
		
		return new ResponseEntity<>(s.get(0),HttpStatus.CREATED);
		
	}catch(Exception e) {
		e.printStackTrace();
		
	}
		Integer s=400;
	return new ResponseEntity<>(s,HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(Integer id) {

		Optional<Quiz> quiz= quizdao.findById(id);
		System.out.println("At line 54 QuizService:"+quiz);
		List<question> questionFromDB=quiz.get().getQuestions(); 
		
		System.out.println("At line 57 QuizService:"+questionFromDB);
		List<QuestionWrapper> questionForUser= new ArrayList<>();
		
		for(question q:questionFromDB) {
			QuestionWrapper qw= new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			
			questionForUser.add(qw);		
		}
		
		
		return new ResponseEntity<>(questionForUser,HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(Integer id, List<Response> response) {
		// TODO Auto-generated method stub
		int right_ans=0;
		Optional<Quiz> quiz= quizdao.findById(id);
		List<question> questionFromDB=quiz.get().getQuestions(); 
		int i=0;
		for(question q: questionFromDB) {
			if(q.getId().equals(response.get(i).getId())) {
				if(q.getRightAnswer().equalsIgnoreCase(response.get(i).getResponse())) {
					right_ans++;
				}
			}
			i++;
		}
		
		System.out.println("Right ans--"+right_ans);
		
		return new ResponseEntity<>(right_ans,HttpStatus.OK);
	}
}