package com.sapient.trading.models;

import java.util.List;

public class BlockForOrderManagement {
	private String blockID;
	private String blockName;
	private List<Order> listOfOrders;
	public BlockForOrderManagement(String blockID, String blockName, List<Order> listOfOrders) {
		super();
		this.blockID = blockID;
		this.blockName = blockName;
		this.listOfOrders = listOfOrders;
	}
	public String getBlockID() {
		return blockID;
	}
	public void setBlockID(String blockID) {
		this.blockID = blockID;
	}
	public String getBlockName() {
		return blockName;
	}
	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	public List<Order> getListOfOrders() {
		return listOfOrders;
	}
	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
	
}
