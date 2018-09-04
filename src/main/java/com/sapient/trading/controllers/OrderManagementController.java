package com.sapient.trading.controllers;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.sapient.trading.models.BlockForOrderManagement;
import com.sapient.trading.models.Order;
import com.sapient.trading.repos.BlockCreationRepo;
import com.sapient.trading.repos.OrderCreationRepo;
import com.sapient.trading.repos.UserSession;

@Controller
public class OrderManagementController {
	//CompanyReceiver compReceiver;
	private int orderID = 101;
	private int blockID = 201;
	Order order;
	BlockForOrderManagement block;
	private String manager="";
	boolean res = false;
	String orderid;
	String blockid;
	List<Order> listOfOerders;
	
	@Autowired
	UserSession session;
	
	@RequestMapping(path="/createOrder",method=RequestMethod.GET)

	public String receive(Model model, @RequestParam("company")String companyName, @RequestParam("price")String companyPrice, @RequestParam("ticker")String companyTicker) {
		model.addAttribute("cname", companyName);
		model.addAttribute("price", companyPrice);
		model.addAttribute("ticker", companyTicker);
		model.addAttribute("isOrdersPage", false);
		model.addAttribute("activeTab", 1);
		model.addAttribute("profileType", session.getAuthorities().getAccountType());
		model.addAttribute("name", session.getUser().getUsername());

		return "CreateOrder";
	}
	@RequestMapping(path="/createOrder",method=RequestMethod.POST)
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
		blockid = blockID+"";
		OrderCreationRepo ocr = new OrderCreationRepo();
		ArrayList<Order> listOfOrders = new ArrayList<>();
		if(totalQuantity>10000) {
			
			int num= totalQuantity/10000;
			int residue = totalQuantity%10000;
			if(residue>0)
				num++;
			for(int i =0;i<num;i++) {
				orderid= orderID+"";
				if(i==num-1) {
					order = new Order(orderid, "APPL", side, type, residue, "Apple", 
							manager, portfolioID, allocatedQuantity, currentPrice, timeCreated, limitPrice, stopPrice);
					res = ocr.saveOrder(order);
					listOfOrders.add(order);
					orderID++;
				}else {
					order = new Order(orderid, "APPL", side, type, 10000, "Apple", 
							manager, portfolioID, allocatedQuantity, currentPrice, timeCreated, limitPrice, stopPrice);
					res = ocr.saveOrder(order);
					listOfOrders.add(order);
					orderID++;
				}	
			}
		}else {
			orderid= orderID+"";
			order = new Order(orderid, "APPL", side, type, totalQuantity, "Apple", 
					manager, portfolioID, allocatedQuantity, currentPrice, timeCreated, limitPrice, stopPrice);
			res = ocr.saveOrder(order);
			listOfOrders.add(order);
			orderID++;
		}
		
		block = new BlockForOrderManagement(blockid,"Some",listOfOrders);
		blockID++;
		
		
////		OrderValidator validator = new OrderValidator();
//		
//		// Insert error page here for invalid orders
//		if(validator.validateOrder(order)) {
//			System.out.println("Invalid Order!");
//		}
		
		
		
		BlockCreationRepo bcr = new BlockCreationRepo();
		res = bcr.updateBlockOrder(block);
		res = bcr.updateBlockDetails(block);
		
		return res;
	}
	
	
}




