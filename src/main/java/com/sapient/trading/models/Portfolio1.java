
package com.sapient.trading.models;

import java.util.List;

public class Portfolio1 {
	String portfolioid;
	String portfolioname;
	String portfoliomanager;
	List<String> traders;
	
	public Portfolio1(String portfolioid, String portfolioname, String portfoliomanager, List<String> traders) {
		super();
		this.portfolioid = portfolioid;
		this.portfolioname = portfolioname;
		this.portfoliomanager = portfoliomanager;
		this.traders = traders;
	}

	public String getPortfolioid() {
		return portfolioid;
	}

	public void setPortfolioid(String portfolioid) {
		this.portfolioid = portfolioid;
	}

	public String getPortfolioname() {
		return portfolioname;
	}

	public void setPortfolioname(String portfolioname) {
		this.portfolioname = portfolioname;
	}

	public String getPortfoliomanager() {
		return portfoliomanager;
	}

	public void setPortfoliomanager(String portfoliomanager) {
		this.portfoliomanager = portfoliomanager;
	}

	public List<String> getTraders() {
		return traders;
	}

	public void setTraders(List<String> traders) {
		this.traders = traders;
	}

	@Override
	public String toString() {
		return "Portfolio [portfolioid=" + portfolioid + ", portfolioname=" + portfolioname + ", portfoliomanager="
				+ portfoliomanager + ", traders=" + traders + "]";
	}
	
	
	
	
}
