package com.sapient.trading.controllers;


import java.sql.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sapient.trading.helper.ConnectionManager;
import com.sapient.trading.models.Order;
import com.sapient.trading.repos.OrderCreationRepo;

@Controller
public class OrderManagementController {
	//CompanyReceiver compReceiver;
	private int orderID = 101;
	Order order;
	private String manager="";
	boolean res = false;
	@RequestMapping(path="/createOrder",method=RequestMethod.GET)
	public boolean createOrder(Model model, 
			@RequestParam("portfolioID")String portfolioID,
			//@RequestParam("company")Company company,
			@RequestParam("Buy/Sell")String side,
			@RequestParam("type")String type,
			@RequestParam("totalQuantity")int totalQuantity,
			@RequestParam("allocatedQuantity")int allocatedQuantity,
			@RequestParam("currentPrice")float currentPrice,
			@RequestParam("timeCreated")Date timeCreated,
			@RequestParam("limitPrice")float limitPrice,
			@RequestParam("stopPrice")float stopPrice) {
		
		timeCreated = new Date(System.currentTimeMillis());
		
		String orderid = orderID+"";
		orderID++;
		
		order = new Order(orderid, "APPL", side, type, totalQuantity, "Apple", 
				manager, portfolioID, allocatedQuantity, currentPrice, timeCreated, limitPrice, stopPrice);
		
		OrderValidator validator = new OrderValidator();
		
		// Insert error page here for invalid orders
		if(validator.validateOrder(order)) {
			System.out.println("Invalid Order!");
		}
		
		OrderCreationRepo ocr = new OrderCreationRepo();
		res = ocr.saveOrder(order);
		
		return res;
	}
	
}
