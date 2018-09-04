package com.sapient.trading.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import pl.zankowski.iextrading4j.api.exception.IEXTradingException;
import pl.zankowski.iextrading4j.api.refdata.ExchangeSymbol;


public class CompData {
	/** tickers holds the mapping of a company's name to it's ticker. */
	Map<String, String> tickers;
	
	/** compName holds the names of all the companies listed on IEX. */
	List<String> compName;
	
	/******************************Constructors*******************************/
	
	/**
	 * Initializes a new CompData Object with tickers as a HashMap of 
	 * <String,String> and compName as an arrayList of <String>
	 */
	public CompData() {
		super();
		this.tickers = new HashMap<String, String>();
		this.compName = new ArrayList<String>();
	}
	
	/**********************************Methods********************************/
	
	/**
	 * addData takes in a List of data returned from the 
	 * IEX api and runs the add method of this class for 
	 * each of the elements in the list.
	 * 
	 * @param esList
	 * 		  List of data about companies
	 */
	public void addData(List<ExchangeSymbol> esList) {
		esList.stream().forEach(es -> this.add(es));
		
	}

	/********************************************************************************
	 * takes in list of exchangesymbol info and returns a list of just company names
	 * used for live search 
	 * @param esList
	 * @return list of company names
	 * 
	 * */
	public List<String> allCompNames(List<ExchangeSymbol> esList){
		List<String> allComps = esList.stream().map(p->p.getName()).collect(Collectors.toList());
		return allComps;
	}
	
	
	/**
	 * add takes in an ExchangeSymbol object and adds data to the 
	 * Map (tickers) and List (compName)
	 * tickers holds the company name and the ticker
	 * compName holds the company name
	 * 
	 * @param es
	 * 		  Data about a company
	 */
	public void add(ExchangeSymbol es) {
		this.tickers.put(es.getName().toLowerCase(), es.getSymbol().toLowerCase());
		this.compName.add(es.getName().toLowerCase());
	}
	
	/**
	 * findTickers looks for and returns any company name that contains 
	 * the string cName.
	 * 
	 * @param cName
	 * 		  Partial name or full name of company
	 * 
	 * @return a List of Strings of tickers where the company name contains 
	 * the string cName
	 */
	public List<String> findTickers(String cName) {
		List<String> results = this.compName.stream().
				filter(comp -> comp.contains(cName.toLowerCase()))
				.collect(Collectors.toList());
		if(results.size() > 10) {
			results = results.subList(0, 10);
		}
		if(results.size() == 0) {
			throw new IEXTradingException("ERROR");
		}
		return results;
	}
	
	/**
	 * findTicker runs the method this.findTickers(cName) and then returns 
	 * the first element of the list that the findTickers function returns.
	 * 
	 * @param name
	 * 		  Partial name or full name of company
	 * 
	 * @return first element of list of Strings
	 */
	public String findTicker(String name) {
		List<String> results = this.findTickers(name);
		return this.tickers.get(results.get(0));
	}
	
	/**
	 * tickers finds a list of tickers that include the partial or full
	 * ticker in the parameter name.
	 * 
	 * @param name
	 * 		  Partial name or full name of company
	 * 
	 * @return first element of list of Strings
	 */
	public List<String> tickers(String name) {
		List<String> results = this.tickers.values().stream().
				filter(comp -> comp.contains(name.toLowerCase()))
				.collect(Collectors.toList());
		if(results.size() > 10) {
			results = results.subList(0, 10);
		}
		if(results.size() == 0) {
			throw new IEXTradingException("ERROR");
		}
		return results;
	}
	
}
