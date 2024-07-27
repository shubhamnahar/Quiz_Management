package com.no_one.demo.Logs;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.no_one.demo.model.question;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER =LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.no_one.demo.Controller.QuestionController.GetAllQuestions() )")
	public void GetAllQuestions_Log() {
		LOGGER.info("inside Log function before AllQuestions");
//		LOGGER.debug("This is a debug message");
//		LOGGER.info("This is an info message");
//		LOGGER.warn("This is a warn message");
//		LOGGER.error("This is an error message");
	}
	
	@AfterThrowing(pointcut="execution(public * com.no_one.demo.Controller.QuestionController.GetAllQuestions() )", throwing = "ex")
	public void GetAllQuestions_Error(Exception ex) {
//		LOGGER.info("inside Log function before AllQuestions");
//		LOGGER.debug("This is a debug message");
//		LOGGER.info("This is an info message");
//		LOGGER.warn("This is a warn message");
		LOGGER.error("This is an error message:"+ex.getMessage());
	}
	
	@After("execution(public * com.no_one.demo.Service.questionService.addQuestion() )")
	public void AddQuestions_Log() {
		System.out.println("Statusss:"+HttpStatus.CREATED);
		LOGGER.info("inside Log function before AllQuestions");
//		LOGGER.debug("This is a debug message");
//		LOGGER.info("This is an info message");
//		LOGGER.warn("This is a warn message");
//		LOGGER.error("This is an error message");
	}
	
	@Before("execution(public * com.no_one.demo.Controller.UserController.createUser() )")
	public void CreateUser_Log() {
		//LOGGER.info("inside Log function before AllQuestions");
		
		System.out.println("Before Create user::::-------- ");
//		LOGGER.debug("This is a debug message");
//		LOGGER.info("This is an info message");
//		LOGGER.warn("This is a warn message");
//		LOGGER.error("This is an error message");
	}
	
}
