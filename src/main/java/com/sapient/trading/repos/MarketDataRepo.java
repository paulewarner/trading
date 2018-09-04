package com.sapient.trading.repos;

import org.springframework.stereotype.Repository;

import com.sapient.trading.models.Company;

import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

@Repository
public class MarketDataRepo {
	/** this is the object that allows for communication with IEX. */
	final IEXTradingClient iexTradingClient = IEXTradingClient.create();
	
	/**********************************Methods********************************/
	/**
	 * finds and returns a Company object that matches the ticker of the String
	 * tick.
	 * 
	 * @param tick
	 * 		  String of ticker of desired company.
	 * 
	 * @return a new company object of the company that matches the ticker.
	 */
	public Company findCompTick(String tick) {
		final Quote quote = iexTradingClient.executeRequest(
				new QuoteRequestBuilder()
		        .withSymbol(tick)
		        .build());
		return new Company(quote.getCompanyName(), quote.getSymbol(), 
				quote.getLatestPrice(), quote.getChange(), 
				quote.getChangePercent());
		
	}
	
	/**
	 * gets more information about a company.
	 * 
	 * @param comp
	 * 		  Company to find more info about.
	 * 
	 * @return the same company but with more added information.
	 */
	public Company detailedInfo(Company comp) {
		final Quote quote = iexTradingClient.executeRequest(
				new QuoteRequestBuilder()
		        .withSymbol(comp.getTick())
		        .build());
		comp.setOpen(quote.getOpen());
		comp.setClose(quote.getClose());
		comp.setPrevClose(quote.getPreviousClose());
		comp.setAvgTotVolume(quote.getAvgTotalVolume());
		comp.setFifty2WeekLow(quote.getWeek52Low());
		comp.setFifty2WeekHigh(quote.getWeek52High());
		comp.setHigh(quote.getHigh());
		comp.setLow(quote.getLow());
		comp.setMrktCap(quote.getMarketCap());
		comp.setPeRatio(quote.getPeRatio());
		comp.setYtdChange(quote.getYtdChange());
		return comp;
		
	}
	
}
