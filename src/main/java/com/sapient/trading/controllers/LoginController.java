package com.sapient.trading.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.trading.repos.UserRepository;



@Controller
public class LoginController {

	@Autowired
	UserRepository repo;
	
	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String loginPage(Model model){
		return "testLogin";
	}
	
	@RequestMapping(path="/portfolioX",method=RequestMethod.POST)
	public String portfolioPage(Model model ,@RequestParam("userId") String userId,@RequestParam("password") String password){		
		System.out.println("Controller code invoked..");
		// fetch courses from db.. repo
		int valid = new UserRepository().findAllUsers(userId,password);
		if(valid==1){
			System.out.println("login success");
			return "testPortfolio";
		}
		else if(valid == 2){
			String message ="Password Incorrect!";
			model.addAttribute("message",message);
			return "testLogin";
		}

		else{
			System.out.println("login again");
			String message ="User not found!!";
			model.addAttribute("message",message);
			return "testLogin";
			}		
	}
	

	
	@RequestMapping(path="/registration",method=RequestMethod.GET)
	public String registrationPage(Model model){
		return "testRegistration";
	}

	
	@RequestMapping(path="/loginX",method=RequestMethod.POST)
	public String portfolioPage2(Model model ,@RequestParam("userId") String userId,@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("authority") String authority){
		String message ="User registered";
		model.addAttribute("message",message);
		new UserRepository().addUser(userId,username,password,authority);
		
		
		return "testLogin";
	}
	

}
