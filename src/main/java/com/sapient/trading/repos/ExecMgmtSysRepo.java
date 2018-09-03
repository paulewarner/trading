package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sapient.trading.helper.ConnectionManager;
import com.mysql.jdbc.PreparedStatement;
import com.sapient.trading.models.Block;
import com.sapient.trading.models.EquityResponse;
import com.sapient.trading.models.Order;

@Repository
public class ExecMgmtSysRepo {
	
	private Block block;
	private Order order;
	static Connection currentConn = null;
	static ResultSet rs = null;
	
	public boolean orderUpdate(Order newOrder, EquityResponse eqResponse) {
		
		return true;
	}
	
	public boolean blockUpdate(Block block, EquityResponse eqResponse) {
		
		return true;
	}
	
	public List<Order> retrieveBlock(Block block) {
		List<Order> blockOrders = new ArrayList<Order>();
		
		
		try {
			
			currentConn = ConnectionManager.getConnection();
			PreparedStatement stmt = (PreparedStatement) currentConn.prepareStatement("SELECT * from equity.order a");
			//stmt.setString(1, email);
			//System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				
			}
			rs.next();
			String tempPass = rs.getString("password");
			int tempID = rs.getInt("idusers");
			rs.close();
			
			
			System.out.println("Connection closed...");

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return blockOrders;
	}

}
