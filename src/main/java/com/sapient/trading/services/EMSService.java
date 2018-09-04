package com.sapient.trading.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.sapient.trading.models.EquityResponse;
import com.sapient.trading.models.Order;

public class EMSService {
	
	BrokerService bs = new BrokerService();
	
	public List<Order> forwardOrder(Order o) {
		List<Order> tempOrders = new ArrayList<Order>();
		
		
			
			System.out.println(o);
			List<EquityResponse> eqResponses = new ArrayList<EquityResponse>();
			
			//System.out.println("o.getTotalQuantity()" + o);
			int total = o.getTotalQuantity();
			System.out.println("Total amount: " + total + " of order: " + o.getOrderId());
			if(total >= 1000 && total < 10000) {
				int remainder = total % 100;
				int divisions = (total - remainder) / 100;
				int count = 0;
				
				Order tempOrder = o;
				if(remainder > 0) {
					tempOrder.setTotalQuantity(remainder);
					eqResponses.add(this.forwarding(tempOrder));
				}
				
				while(count < divisions) {
					tempOrder.setTotalQuantity(100);
					eqResponses.add(this.forwarding(tempOrder));
					count++;
				}
				
				o.setTotalQuantity(total);
				tempOrders.add(this.handleResponses(eqResponses, o));
			}
			
			else if(total < 1000 ){
				
				Order tempOrder = o;
				tempOrder.setTotalQuantity(total);
				eqResponses.add(this.forwarding(tempOrder));
				tempOrders.add(this.handleResponses(eqResponses, o));
				
			}
			
			else if(total > 10000 ){
				
				int remainder = total % 500;
				int divisions = (total - remainder) / 500;
				int count = 0;
				
				Order tempOrder = o;
				if(remainder > 0) {
					tempOrder.setTotalQuantity(remainder);
					eqResponses.add(this.forwarding(tempOrder));
				}
				
				while(count < divisions) {
					tempOrder.setTotalQuantity(500);
					eqResponses.add(this.forwarding(tempOrder));
					count++;
				}
				
				o.setTotalQuantity(total);
				tempOrders.add(this.handleResponses(eqResponses, o));
				
			}
		
		return tempOrders;
	}
	
	private EquityResponse forwarding(Order order) {
		return bs.executeOrder(order);	
	}
	
	private Order handleResponses(List<EquityResponse> responses, Order order) {
		System.out.println("order: " + order.getOrderId() + " | total: " + order.getTotalQuantity());

		int totalAllocated = 0;
		float actualPrice = 0;
		List<Float> actualPrices = new ArrayList<>();
		Date date = new Date(0);
		for(EquityResponse eqr : responses) {
			actualPrices.add(eqr.getActualPrice());
			totalAllocated += eqr.getAllocatedQuantity();
			if(eqr.getTimeExecuted() != null) {
				date = eqr.getTimeExecuted();
			}
			if(eqr.getActualPrice() != 0) {
				actualPrice = eqr.getActualPrice();
			}
		}
		order.setAllocatedQuantity(totalAllocated);
		//order.setActualPrice(actualPrice);
		order.setTimeExecuted(date);
		order.setOpenQuantity(order.getTotalQuantity() - totalAllocated);
		
		return order;
	}
}
