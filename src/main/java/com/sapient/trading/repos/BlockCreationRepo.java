package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sapient.trading.helper.ConnectionManager;
import com.sapient.trading.models.BlockForOrderManagement;
import com.sapient.trading.models.Order;

public class BlockCreationRepo {

	Connection conn = null;
	
	int rs;
	boolean result = true;
	
	public static void main(String args[]) {
		List<Order> listOfOrders = new ArrayList<>();
		Date timeCreated = new Date(System.currentTimeMillis());
		Order order = new Order("661", "APPL", "Buy", "GTD", 12, "Apple", 
				"ma", "203", 2, 343.34f, timeCreated, 44.67f, 23.78f);
		OrderCreationRepo ocr = new OrderCreationRepo();
		ocr.saveOrder(order);
		listOfOrders.add(order);
		BlockForOrderManagement block = new BlockForOrderManagement("447", "asjkhgjkd", listOfOrders);
		BlockCreationRepo bcr = new BlockCreationRepo();
		
		System.out.println(bcr.updateBlockDetails(block));
		System.out.println(bcr.updateBlockOrder(block));
	}

	public boolean updateBlockDetails(BlockForOrderManagement block) {
		conn = ConnectionManager.getConnection();
		try {
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("INSERT into equity.block_details (Block_ID, Block_Name) VALUES (?,?)"); 
					
			stmt.setString(1, block.getBlockID());
			stmt.setString(2, block.getBlockName());
			
			rs = stmt.executeUpdate();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean updateBlockOrder(BlockForOrderManagement block) {
		conn = ConnectionManager.getConnection();
		for (int i = 0; i < block.getListOfOrders().size(); i++) {
			try {
				PreparedStatement stmt = (PreparedStatement) conn
						.prepareStatement("INSERT into equity.block_order (BlockID, OrderID)" + "VALUES (?,?)");
				stmt.setString(1, block.getBlockID());
				stmt.setString(2, block.getListOfOrders().get(i).getOrderId());
				rs = stmt.executeUpdate();
				conn.close();
			} catch (SQLException e) {
				result = false;
				e.printStackTrace();
			}
		}
		return result;
	}

	

}

