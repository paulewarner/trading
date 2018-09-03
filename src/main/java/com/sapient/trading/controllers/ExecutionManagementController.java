package com.sapient.trading.controllers;
import java.util.List;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sapient.trading.models.EquityResponse;
import com.sapient.trading.models.Order;
import com.sapient.trading.repos.ExecMgmtSysRepo;
import com.sapient.trading.services.EMSService;
import java.sql.Connection;

public class ExecutionManagementController {



	
	public static void main(String[] args) {
				
		ExecMgmtSysRepo emsRepo = new ExecMgmtSysRepo();
			
		Order or = emsRepo.retrieveOrder("1a4");
		System.out.println(or);
		
		
		or.setAllocatedQuantity(500);
		or.setOpenQuantity(500);
		emsRepo.orderUpdate(or);
		
		or = emsRepo.retrieveOrder("1a4");
		System.out.println(or);
		
	}



}
