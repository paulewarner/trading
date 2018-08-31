package com.sapient.trading.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sapient.trading.models.Order;

@Controller
public class OrderManagementController {

	
	Order order;
	@RequestMapping(path="/createOrder",method=RequestMethod.GET)
	public boolean createOrder(Model model, @RequestParam("portfolioID")int portfolioID,
			@RequestParam("Buy")boolean side,
			@RequestParam("quantity")int quantity,
			@RequestParam("currentPrice")double currentPrice,
			@RequestParam("targetPrice")double targetPrice,
			@RequestParam("stopLoss")double stopLoss,
			@RequestParam("notes")String notes) {
		order = new Order(side, quantity, currentPrice, targetPrice, stopLoss, notes);
		// ConnectionManager cm = 
		return true;
	}
}
