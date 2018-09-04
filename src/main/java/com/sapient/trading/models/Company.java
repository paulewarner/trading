package com.sapient.trading.models;

import java.math.BigDecimal;

public class Company {
	private String name;
	private String tick;
	private BigDecimal price;
	private BigDecimal priceChange;
	private BigDecimal percentChange;
	
	private BigDecimal open;
	private BigDecimal close;
	private BigDecimal high;
	private BigDecimal low;
	private BigDecimal prevClose;
	private BigDecimal fifty2WeekHigh;
	private BigDecimal fifty2WeekLow;
	private BigDecimal peRatio;
	private BigDecimal avgTotVolume;
	private BigDecimal mrktCap;
	private BigDecimal ytdChange;
	
	
	/******************Constructors*************************/
	public Company(String name, String tick, BigDecimal price, 
			BigDecimal priceChange, BigDecimal percentChange) {
		super();
		this.name = name;
		this.tick = tick;
		this.price = price;
		this.priceChange = priceChange;
		this.percentChange = percentChange;
	}


	/*********************Getters*************************/
	public String getName() {
		return name;
	}

	public String getTick() {
		return tick;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public BigDecimal getPriceChange() {
		return priceChange;
	}
	
	public BigDecimal getPercentChange() {
		return percentChange;
	}
	
	public BigDecimal getOpen() {
		return open;
	}

	public BigDecimal getClose() {
		return close;
	}

	public BigDecimal getHigh() {
		return high;
	}

	public BigDecimal getLow() {
		return low;
	}

	public BigDecimal getPrevClose() {
		return prevClose;
	}

	public BigDecimal getFifty2WeekHigh() {
		return fifty2WeekHigh;
	}

	public BigDecimal getFifty2WeekLow() {
		return fifty2WeekLow;
	}

	public BigDecimal getPeRatio() {
		return peRatio;
	}

	public BigDecimal getAvgTotVolume() {
		return avgTotVolume;
	}

	public BigDecimal getMrktCap() {
		return mrktCap;
	}

	public BigDecimal getYtdChange() {
		return ytdChange;
	}

	/*******************Setters*************************/
	public void setOpen(BigDecimal open) {
		this.open = open;
	}

	public void setClose(BigDecimal close) {
		this.close = close;
	}

	public void setHigh(BigDecimal high) {
		this.high = high;
	}

	public void setLow(BigDecimal low) {
		this.low = low;
	}

	public void setPrevClose(BigDecimal prevClose) {
		this.prevClose = prevClose;
	}

	public void setFifty2WeekHigh(BigDecimal fifty2WeekHigh) {
		this.fifty2WeekHigh = fifty2WeekHigh;
	}

	public void setFifty2WeekLow(BigDecimal fifty2WeekLow) {
		this.fifty2WeekLow = fifty2WeekLow;
	}

	public void setPeRatio(BigDecimal peRatio) {
		this.peRatio = peRatio;
	}

	public void setAvgTotVolume(BigDecimal avgTotVolume) {
		this.avgTotVolume = avgTotVolume;
	}

	public void setMrktCap(BigDecimal mrktCap) {
		this.mrktCap = mrktCap;
	}

	public void setYtdChange(BigDecimal ytdChange) {
		this.ytdChange = ytdChange;
	}

	/*******************Methods*************************/
	@Override
	public String toString() {
		return "Company [name=" + name + ", tick=" + tick +
				", price=" + price + ", priceChange=" + priceChange
				+ ", percentChange=" + percentChange + "]";
	}

}
