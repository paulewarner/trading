package com.sapient.trading.controllers;

import com.sapient.trading.models.Order;

public class OrderValidator {

	public boolean  validateOrder(Order order) {
		// TODO Auto-generated method stub
		if(order.getStopPrice()>order.getcurrentPrice()) {
			return false;
		}
		if(order.getSide().equals("Buy") && order.getLimitPrice() > order.getcurrentPrice()) {
			return false;
		}
		if(order.getSide().equals("Sell") && order.getLimitPrice() < order.getcurrentPrice()) {
			return false;
		}
		return true;
	}

	

}
