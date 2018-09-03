package com.sapient.trading.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sapient.trading.models.Order;

@Controller
public class OrderManagementController {

<<<<<<< Upstream, based on origin/dev
	
=======
	//CompanyReceiver compReceiver;
	private int orderID = 102401;
>>>>>>> 347622d Edited orderManagementController and order
	Order order;
	private String manager;
	@RequestMapping(path="/createOrder",method=RequestMethod.GET)
<<<<<<< Upstream, based on origin/dev
	public boolean createOrder(Model model, @RequestParam("portfolioID")int portfolioID,
=======
	public boolean createOrder(Model model,
			
			@RequestParam("company")Company company,
>>>>>>> 347622d Edited orderManagementController and order
			@RequestParam("Buy")boolean side,
			@RequestParam("type")String type,
			@RequestParam("quantity")int totalQuantity,
			@RequestParam("portfolioID")int portfolioID,
			@RequestParam("quantity")int allocatedQuantity,
			@RequestParam("currentPrice")double currentPrice,
<<<<<<< Upstream, based on origin/dev
			@RequestParam("targetPrice")double targetPrice,
			@RequestParam("stopLoss")double stopLoss,
			@RequestParam("notes")String notes) {
		order = new Order(side, quantity, currentPrice, targetPrice, stopLoss, notes);
		// ConnectionManager cm = 
=======
			@RequestParam("timeCreated")Date timeCreated,
			@RequestParam("limitPrice")double limitPrice,
			@RequestParam("stopPrice")double stopPrice) {
		
		
		order = new Order(orderID++, company.getSymbol(), side, type, totalQuantity, company.getStockName(),
				manager, portfolioID, allocatedQuantity, currentPrice, timeCreated, limitPrice, stopPrice);
		ConnectionManager cm = 
>>>>>>> 347622d Edited orderManagementController and order
		return true;
	}
}
