
package com.sapient.trading.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.trading.repos.HomePageRepo;
import com.sapient.trading.repos.PortfolioContentRepo;
import com.sapient.trading.repos.UserSession;
import com.sapient.trading.models.Portfolio;
import com.sapient.trading.models.PortfolioContent;

@Controller
public class tradingControllers {
	@Autowired
	HomePageRepo homerepo;
	@Autowired
	PortfolioContentRepo contentrepo;
	@Autowired
	UserSession session;

	@RequestMapping(path="/Homepage", method=RequestMethod.GET)
	public String loginpage(Model model){
		HashSet<Portfolio> portfolio1s = new HashSet<Portfolio>();
		portfolio1s=homerepo.getlistofportfolios(session.getUser().getUserId());
		System.out.println("result:");
		for(Portfolio p : portfolio1s) {
			System.out.println(p);
		}
		
		model.addAttribute("portfolios",portfolio1s);
		model.addAttribute("name", session.getUser().getUsername());
		System.out.println(session.getAuthorities());
		model.addAttribute("portfolioType", session.getAuthorities().getAccountType());
		return "Homepage";		
	}
	@RequestMapping(path="/profile", method=RequestMethod.GET)
	public String fetchCourses(Model model,@RequestParam("pId") String id){

		model.addAttribute("name", session.getUser().getUsername());
		model.addAttribute("portfolioType", session.getAuthorities().getAccountType());
		List<PortfolioContent> portfoliocontents = new ArrayList<PortfolioContent>();
		portfoliocontents= (List<PortfolioContent>) contentrepo.getlistoforders(id);
		System.out.println(portfoliocontents);
		model.addAttribute("portfoliocontents",portfoliocontents);
		return "PortfolioContentPage";
	}
}


