package com.sapient.trading.models;

public class PortfolioContent {
	String symbol;
	int quantity;
	int value;
	int status;
	String stockname;
	String limitprice;
	String stopprice;
	String date;
	String allocated;
	String open;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStockname() {
		return stockname;
	}
	public void setStockname(String stockname) {
		this.stockname = stockname;
	}
	public String getLimitprice() {
		return limitprice;
	}
	public void setLimitprice(String limitprice) {
		this.limitprice = limitprice;
	}
	public String getStopprice() {
		return stopprice;
	}
	public void setStopprice(String stopprice) {
		this.stopprice = stopprice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAllocated() {
		return allocated;
	}
	public void setAllocated(String allocated) {
		this.allocated = allocated;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	@Override
	public String toString() {
		return "PortfolioContent [symbol=" + symbol + ", quantity=" + quantity + ", value=" + value + ", status="
				+ status + ", stockname=" + stockname + ", limitprice=" + limitprice + ", stopprice=" + stopprice
				+ ", date=" + date + ", allocated=" + allocated + ", open=" + open + "]";
	}
	public PortfolioContent(String symbol, int quantity, int value, int status, String stockname, String limitprice,
			String stopprice, String date, String allocated, String open) {
		super();
		this.symbol = symbol;
		this.quantity = quantity;
		this.value = value;
		this.status = status;
		this.stockname = stockname;
		this.limitprice = limitprice;
		this.stopprice = stopprice;
		this.date = date;
		this.allocated = allocated;
		this.open = open;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allocated == null) ? 0 : allocated.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((limitprice == null) ? 0 : limitprice.hashCode());
		result = prime * result + ((open == null) ? 0 : open.hashCode());
		result = prime * result + quantity;
		result = prime * result + status;
		result = prime * result + ((stockname == null) ? 0 : stockname.hashCode());
		result = prime * result + ((stopprice == null) ? 0 : stopprice.hashCode());
		result = prime * result + ((symbol == null) ? 0 : symbol.hashCode());
		result = prime * result + value;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortfolioContent other = (PortfolioContent) obj;
		if (allocated == null) {
			if (other.allocated != null)
				return false;
		} else if (!allocated.equals(other.allocated))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (limitprice == null) {
			if (other.limitprice != null)
				return false;
		} else if (!limitprice.equals(other.limitprice))
			return false;
		if (open == null) {
			if (other.open != null)
				return false;
		} else if (!open.equals(other.open))
			return false;
		if (quantity != other.quantity)
			return false;
		if (status != other.status)
			return false;
		if (stockname == null) {
			if (other.stockname != null)
				return false;
		} else if (!stockname.equals(other.stockname))
			return false;
		if (stopprice == null) {
			if (other.stopprice != null)
				return false;
		} else if (!stopprice.equals(other.stopprice))
			return false;
		if (symbol == null) {
			if (other.symbol != null)
				return false;
		} else if (!symbol.equals(other.symbol))
			return false;
		if (value != other.value)
			return false;
		return true;
	}
	
	
}
