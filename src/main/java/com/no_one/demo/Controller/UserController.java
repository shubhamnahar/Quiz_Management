package com.no_one.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.no_one.demo.Service.UserService;
import com.no_one.demo.model.UserTable;

@RestController
@RequestMapping("users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserService userservice;

	@GetMapping("getUsers")
	public ResponseEntity<List<UserTable>> getUser(){
		
		return userservice.getUser();
	}
	
	@PostMapping(value = "/createUser",  consumes = "application/json", produces = "application/json")
	public ResponseEntity<String> createUser(@RequestBody UserTable usertable) {

//		System.out.println("usertable::" + usertable.toString());
		logger.info("Received createUser request with payload: {}", usertable.toString());
		return userservice.createUser(usertable);
//		return ResponseEntity<>("Success",HttpStatus.OK);

	}
}
