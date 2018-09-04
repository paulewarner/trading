package com.sapient.trading.models;

import java.sql.Date;

public class EquityResponse {
	
	private String orderID;
	private int openQuantity;
	private int allocatedQuantity;
	private String status;
	private float actualPrice;
	private Date timeExecuted;
	private boolean executed;
	
	public EquityResponse(String orderID, int openQuantity, int allocatedQuantity, String status, boolean executed) {
		this.orderID = orderID;
		this.openQuantity = openQuantity;
		this.allocatedQuantity = allocatedQuantity;
		this.status = status;
		this.executed = executed;
	}

	public boolean isExecuted() {
		return executed;
	}

	public String getOrderID() {
		return orderID;
	}

	public int getOpenQuantity() {
		return openQuantity;
	}

	public int getAllocatedQuantity() {
		return allocatedQuantity;
	}

	public String getStatus() {
		return status;
	}

	public float getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(float actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Date getTimeExecuted() {
		return timeExecuted;
	}

	public void setTimeExecuted(Date timeExecuted) {
		this.timeExecuted = timeExecuted;
	}
	
}
