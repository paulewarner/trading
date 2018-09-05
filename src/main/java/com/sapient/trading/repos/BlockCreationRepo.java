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

