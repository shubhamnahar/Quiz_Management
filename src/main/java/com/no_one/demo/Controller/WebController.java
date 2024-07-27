package com.no_one.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller   // Denotes this class as Web Request Handler
public class WebController {
	
	@RequestMapping("/")
	public String HelloWorld() {
		return "HelloWorld.jsp";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login.jsp";
	}
	
	@RequestMapping("/logout")
	public String logoutPage() {
		return "logout.jsp";
	}
	
	@GetMapping("questions")
    public String questionsPage() {
        return "questions.jsp";  // This resolves to /WEB-INF/jsp/questions.jsp
    }
	
	@GetMapping("AddQuestion")
	public String AddQuestion() {
		return "AddQuestion.jsp";
	}
	@GetMapping("CreateQuiz")
	public String CreateQuiz() {
		return "CreateQuiz.jsp";			
	}
	
	@GetMapping("getQuiz")
	public String getQuiz() {
		return "Quiz.jsp";			
	}

	@GetMapping("Result")
	public String getResult(@RequestParam Integer ID,Model model) {
		System.out.println("---------------------------------------------Id::---------"+ID);
		model.addAttribute("ID", ID);
		return "Result.jsp";			
	}
	
	@GetMapping("createUsers")
	public String createUser() {
		return "NewUsers.jsp";
	}
}
