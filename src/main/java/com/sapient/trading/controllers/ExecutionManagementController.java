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
	public String handleForwardedOrders(@RequestParam("order") Order order){
		
//		Retrieving order
		EMSRepo.retrieveOrder( order)
		return "res";
	}
	
	@RequestMapping(path="/forwardBlock", method= RequestMethod.POST)
	public String handleForwardedOrders(@RequestParam("block") Block block){
		
		return "res";
	}
}
