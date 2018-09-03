package com.sapient.trading.services;

import java.sql.Date;
import java.util.Random;
import com.sapient.trading.models.EquityResponse;
import com.sapient.trading.models.Order;

public class BrokerService {
	
	Random rand = new Random();
	long uDate = new java.util.Date().getTime();
	Date date = new Date(uDate);
	
	public EquityResponse executeOrder(Order order) {
		
		EquityResponse eqResponse = null;
		
		
		int outcome = rand.nextInt(3);
		
		switch(outcome) {
		
			case 0: 
				System.out.println("Fully Executed");
				eqResponse = fullyExecuted(order);
				break;
			case 1: 
				System.out.println("Failed to Execute");
				eqResponse = failedExecuted(order);
				break;
			case 2: 
				System.out.println("Partially Executed");
				eqResponse = partiallyExecuted(order);
				break;
			default: System.out.println("Fully Executed");
		}
		
		return eqResponse;
	}
		
	private EquityResponse fullyExecuted(Order order) {
		
//		Will be supplied with api's in future
		float actualPrice = randomFloat(order.getLimitPrice()-10, order.getLimitPrice());
		EquityResponse result = new EquityResponse(order.getOrderId(), 0, order.getTotalQuantity(), "2", true);
		result.setActualPrice(actualPrice);
		result.setTimeExecuted(date);
		return result;
	}
	
	private EquityResponse failedExecuted(Order order) {
//		Will be supplied with api's in future
		EquityResponse result = new EquityResponse(order.getOrderId(), order.getTotalQuantity(), 0, "0", false);
		return result;
	}
	
	private EquityResponse partiallyExecuted(Order order) {
//		Will be supplied with api's in future
		int half = order.getTotalQuantity() / 2;
		float actualPrice = randomFloat(order.getLimitPrice()-10, order.getLimitPrice());
		EquityResponse result = new EquityResponse(order.getOrderId(), half, half, "1", true);
		result.setActualPrice(actualPrice);
		result.setTimeExecuted(date);
		return result;
	}
	
	private float randomFloat(float min, float max) {
		float random = min + rand.nextFloat() * (max - min);
		return random;
 	}

}
