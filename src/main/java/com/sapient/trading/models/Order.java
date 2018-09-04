package com.sapient.trading.models;

import java.sql.Date;

import org.springframework.stereotype.Component;

public class Order {

	private String orderId;
	private String symbol;
	private String side;		// In database its '0' for Buy and '1' for Sell
	private String type;		// In database its '0' for GTD and '1' for GTC
	private int totalQuantity;
	private String stockName;
	private float limitPrice;
	private float stopPrice;
	private String manager;
	private String portfolioID;
	private int openQuantity;
	private int allocatedQuantity;
	private String status;		// In database its '0' for Pending and '1' for Completed
	private float currentPrice;
	private Date timeCreated;
	private Date timeExecuted;
	
	
	public Order(String orderId, String symbol, String side, String type, int totalQuantity, String stockName, String manager, String portfolioID, int allocatedQuantity,
			float currentPrice, Date timeCreated,float limitPrice, float stopPrice) {
		super();
		this.orderId = orderId;
		this.symbol = symbol;
		this.side = side;
		this.type = type;								// Can be either GTD or GTC
		this.totalQuantity = totalQuantity;
		this.stockName = stockName;
		
		this.manager = manager;
		this.portfolioID = portfolioID;
		this.openQuantity = totalQuantity;				//While creation full order is open
		this.allocatedQuantity = allocatedQuantity;		
		this.status = "Pending";						//Will be pending while creation
		this.currentPrice = currentPrice;
		this.timeCreated = timeCreated;
		this.timeExecuted = null;						//Will be assigned when order is completed
		
//		Optional parameters can be passed as last parameters
		this.limitPrice = limitPrice;
		this.stopPrice = stopPrice;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(currentPrice);
		result = prime * result + allocatedQuantity;
		result = prime * result + Float.floatToIntBits(limitPrice);
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + openQuantity;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result + ((portfolioID == null) ? 0 : portfolioID.hashCode());
		result = prime * result + ((side == null) ? 0 : side.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((stockName == null) ? 0 : stockName.hashCode());
		result = prime * result + Float.floatToIntBits(stopPrice);
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + ((timeCreated == null) ? 0 : timeCreated.hashCode());
		result = prime * result + ((timeExecuted == null) ? 0 : timeExecuted.hashCode());
		result = prime * result + totalQuantity;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Order)) {
			return false;
		}
		Order other = (Order) obj;
		if (Float.floatToIntBits(currentPrice) != Float.floatToIntBits(other.currentPrice)) {
			return false;
		}
		if (allocatedQuantity != other.allocatedQuantity) {
			return false;
		}
		if (Float.floatToIntBits(limitPrice) != Float.floatToIntBits(other.limitPrice)) {
			return false;
		}
		if (manager == null) {
			if (other.manager != null) {
				return false;
			}
		} else if (!manager.equals(other.manager)) {
			return false;
		}
		if (openQuantity != other.openQuantity) {
			return false;
		}
		if (orderId == null) {
			if (other.orderId != null) {
				return false;
			}
		} else if (!orderId.equals(other.orderId)) {
			return false;
		}
		if (portfolioID == null) {
			if (other.portfolioID != null) {
				return false;
			}
		} else if (!portfolioID.equals(other.portfolioID)) {
			return false;
		}
		if (side == null) {
			if (other.side != null) {
				return false;
			}
		} else if (!side.equals(other.side)) {
			return false;
		}
		if (status == null) {
			if (other.status != null) {
				return false;
			}
		} else if (!status.equals(other.status)) {
			return false;
		}
		if (stockName == null) {
			if (other.stockName != null) {
				return false;
			}
		} else if (!stockName.equals(other.stockName)) {
			return false;
		}
		if (Float.floatToIntBits(stopPrice) != Float.floatToIntBits(other.stopPrice)) {
			return false;
		}
		if (symbol == null) {
			if (other.symbol != null) {
				return false;
			}
		} else if (!symbol.equals(other.symbol)) {
			return false;
		}
		if (timeCreated == null) {
			if (other.timeCreated != null) {
				return false;
			}
		} else if (!timeCreated.equals(other.timeCreated)) {
			return false;
		}
		if (timeExecuted == null) {
			if (other.timeExecuted != null) {
				return false;
			}
		} else if (!timeExecuted.equals(other.timeExecuted)) {
			return false;
		}
		if (totalQuantity != other.totalQuantity) {
			return false;
		}
		if (type == null) {
			if (other.type != null) {
				return false;
			}
		} else if (!type.equals(other.type)) {
			return false;
		}
		return true;
	}

//	Getters and Setters

	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getSymbol() {
		return symbol;
	}


	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}


	public String getSide() {
		return side;
	}


	public void setSide(String side) {
		this.side = side;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getTotalQuantity() {
		return totalQuantity;
	}


	public void setTotalQuantity(int totalQuantity) {
		this.totalQuantity = totalQuantity;
	}


	public String getStockName() {
		return stockName;
	}


	public void setStockName(String stockName) {
		this.stockName = stockName;
	}


	public float getLimitPrice() {
		return limitPrice;
	}


	public void setLimitPrice(float limitPrice) {
		this.limitPrice = limitPrice;
	}


	public float getStopPrice() {
		return stopPrice;
	}


	public void setStopPrice(float stopPrice) {
		this.stopPrice = stopPrice;
	}


	public String getManager() {
		return manager;
	}


	public void setManager(String manager) {
		this.manager = manager;
	}


	public String getportfolioID() {
		return portfolioID;
	}


	public void setportfolioID(String portfolioID) {
		this.portfolioID = portfolioID;
	}


	public int getOpenQuantity() {
		return openQuantity;
	}


	public void setOpenQuantity(int openQuantity) {
		this.openQuantity = openQuantity;
	}


	public int getAllocatedQuantity() {
		return allocatedQuantity;
	}


	public void setAllocatedQuantity(int allocatedQuantity) {
		this.allocatedQuantity = allocatedQuantity;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public float getcurrentPrice() {
		return currentPrice;
	}


	public void setcurrentPrice(float currentPrice) {
		this.currentPrice = currentPrice;
	}


	public Date getTimeCreated() {
		return timeCreated;
	}


	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}


	public Date getTimeExecuted() {
		return timeExecuted;
	}


	public void setTimeExecuted(Date timeExecuted) {
		this.timeExecuted = timeExecuted;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", symbol=" + symbol + ", side=" + side + ", type=" + type
				+ ", totalQuantity=" + totalQuantity + ", stockName=" + stockName + ", limitPrice=" + limitPrice
				+ ", stopPrice=" + stopPrice + ", manager=" + manager + ", portfolioID=" + portfolioID + ", openQuantity="
				+ openQuantity + ", allocatedQuantity=" + allocatedQuantity + ", status=" + status + ", currentPrice="
				+ currentPrice + ", timeCreated=" + timeCreated + ", timeExecuted=" + timeExecuted + "]";
	}
		
	
		
	
}

