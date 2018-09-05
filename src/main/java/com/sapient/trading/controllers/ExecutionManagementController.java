package com.sapient.trading.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.sapient.trading.models.Block;
import com.sapient.trading.models.EquityResponse;
import com.sapient.trading.models.Order;
import com.sapient.trading.repos.ExecMgmtSysRepo;
import com.sapient.trading.services.EMSService;
import java.sql.Connection;

@Controller
public class ExecutionManagementController {

	@Autowired
	ExecMgmtSysRepo EMSRepo;
	
	@RequestMapping(path="/forwardOrder", method= RequestMethod.POST)
	public String handleForwardedOrders(Model model, @RequestParam("order") String orderID){
		List<Order> li = new ArrayList<Order>();
		Boolean result = false;
//		Retrieving order
		
		System.out.println(orderID);
		Order tmp = EMSRepo.retrieveOrder( orderID.trim() );
		System.out.println("order " + tmp );
		li.add(tmp);
		
//		Creating EMS Service for forwarding 
		EMSService ems = new EMSService();
		
//		Forwarding order
		li = ems.forwardOrder(tmp);
		
//		Updating database
		for(Order o : li) {
			result = EMSRepo.orderUpdate(o);
		}
		
		System.out.println(result);
//		if(result) {
//			model.addAttribute("response", "successfully added");
//		} else {
//			model.addAttribute("response", "failed to add");
//		}
		
		return "redirect:/mvc/Homepage";
	}
	
//	@RequestMapping(path="/forwardBlock", method= RequestMethod.POST)
//	public String handleForwardedBlocks(@RequestParam("block") String blockID){
//		List<Order> li = new ArrayList<Order>();
//		
//		
////		Creating EMS Service for forwarding 
//		EMSService ems = new EMSService();
//		
////		Populating list of orders
//		li = EMSRepo.retrieveBlock(blockID);
//		
////		Forwarding order
//		li = ems.forwardOrder(li);
//		
////		Updating database
//		for(Order o : li) {
//			EMSRepo.orderUpdate(o);
//		}
//		
//		return "res";
//	}
//	
}
