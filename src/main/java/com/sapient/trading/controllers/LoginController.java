package com.sapient.trading.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.trading.models.Authority;
import com.sapient.trading.models.User;
import com.sapient.trading.repos.UserRepository;
import com.sapient.trading.repos.UserSession;



@Controller
public class LoginController {
	
	@Autowired
	UserSession session;

	@Autowired
	UserRepository repo;
	
	@RequestMapping(path="/login",method=RequestMethod.GET)
	public String loginPage(Model model){
		return "login";
	}
	
	@RequestMapping(path="/logout", method=RequestMethod.POST)
	public String logout(Model model) {
		session.setAuthorities(null);
		session.setUser(null);
		return "redirect:/mvc/login";
	}
	
	@RequestMapping(path="/portfolioX",method=RequestMethod.POST)
	public String portfolioPage(Model model ,@RequestParam("userId") String userId,@RequestParam("password") String password){		
		System.out.println("Controller code invoked..");
		// fetch courses from db.. repo
		UserRepository repository = new UserRepository();
		int valid = repository.findAllUsers(userId,password);
		if(valid==1){
			User loggedInUser = repository.getUser();
			Authority loggedInAuthority = repository.getAuthority();
			session.setUser(loggedInUser);
			session.setAuthorities(loggedInAuthority);
			System.out.println("login success");
			return "redirect:/mvc/Homepage";
		}
		else if(valid == 2){
			String message ="User name and password mismatch!";
			model.addAttribute("message",message);
			return "login";
		}

		else{
			System.out.println("login again");
			String message ="User name and password mismatch!";
			model.addAttribute("message",message);
			return "login";
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
		
		
		return "login";
	}
	
	
	

}
