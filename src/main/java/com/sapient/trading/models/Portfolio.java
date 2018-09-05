
package com.sapient.trading.models;

import java.util.List;

public class Portfolio {
	String portfolioid;
	String portfolioname;
	String portfoliomanager;
	List<String> traders;
	String username;
	
	public Portfolio(String portfolioid, String portfolioname, String portfoliomanager, List<String> traders, String username) {
		super();
		this.portfolioid = portfolioid;
		this.portfolioname = portfolioname;
		this.portfoliomanager = portfoliomanager;
		this.traders = traders;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "Portfolio1 [portfolioid=" + portfolioid + ", portfolioname=" + portfolioname + ", portfoliomanager="
				+ portfoliomanager + ", traders=" + traders + ", username=" + username + "]";
	}

	
	
	
	
	
	
}
