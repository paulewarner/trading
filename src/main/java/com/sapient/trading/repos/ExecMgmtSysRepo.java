package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import com.sapient.trading.models.Block;
import com.sapient.trading.models.EquityResponse;
import com.sapient.trading.models.Order;

@Repository
public class ExecMgmtSysRepo {

	private Block block;
	private Order order;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/equity";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	
public boolean orderUpdate(Order newOrder) {
	
	boolean res = false;
	Connection conn = null;
	
	try {
		// STEP 2: Register JDBC driver
		Class.forName(JDBC_DRIVER);

		// STEP 3: Open a connection
		System.out.println("Connecting to a selected database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connected database successfully...");

		// STEP 4: Execute a query
		System.out.println("Creating statement...");
		java.sql.PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(" UPDATE `equity`.`order` SET `Open_Quantity`= ? , `Allocated_Quantity`= ? , `Status`= ? , `Time_Executed`=? WHERE `OrderID`=? ;");
		
//		Setting open quantity
		stmt.setInt(1, newOrder.getOpenQuantity());
//		Setting closed quantity
		stmt.setInt(2, newOrder.getOpenQuantity());
//		Setting status
		int st=1;
		if(newOrder.getStatus().equals("Pending")) {
			st = 0;
		}
		else {
			st = 1;
		}
		stmt.setInt(3, st);
//		Setting time of execution
		stmt.setDate(4, newOrder.getTimeExecuted());
//		Setting OrderID
		stmt.setString(5, newOrder.getOrderId());
		
		stmt.executeUpdate();
			
		System.out.println("Connection closed...");
		res = true;

	} 
		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} 
		catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} 
	
	
	return res;
}	
			
	
//		Following method returns an order
		public Order retrieveOrder(String orderID) {
			
			Order res = null ;
			Connection conn = null;
			
			try {
				// STEP 2: Register JDBC driver
				Class.forName(JDBC_DRIVER);

				// STEP 3: Open a connection
				System.out.println("Connecting to a selected database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connected database successfully...");

				// STEP 4: Execute a query
				System.out.println("Creating statement...");
				java.sql.PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM `equity`.`order` WHERE `OrderID`= ? ;");
				stmt.setString(1, orderID);
				
				ResultSet rs = stmt.executeQuery();
				
				while( rs.next() ) { 
					String orderId = rs.getString("OrderID");
					String symbol = rs.getString("Symbol");
					String side = rs.getString("Side");
					String type = rs.getString("Type");
					int totalQuantity = rs.getInt("Total_Quantity");
					String stockName = rs.getString("Stock_Name");
					float limitPrice = rs.getFloat("Limit_Price");
					float stopPrice = rs.getFloat("Stop_Price");
					String manager = rs.getString("Manager");
					String porfolioId = rs.getString("Portfolio_ID");
					int openQuantity = rs.getInt("Open_Quantity");
					int allocatedQuantity = rs.getInt("Allocated_Quantity");
					String status = rs.getString("Status");
					float actualPrice = rs.getFloat("Actual_Price");
					Date timeCreated = rs.getDate("Time_Created");
					Date timeExecuted = rs.getDate("Time_executed");
					
					res = new Order(orderId, symbol, side, type, totalQuantity, stockName, manager, porfolioId,
							allocatedQuantity, actualPrice, timeCreated, limitPrice, stopPrice);
					if(timeExecuted != null) {
						res.setTimeExecuted(timeExecuted);
					}
					res.setOpenQuantity(openQuantity);
					res.setAllocatedQuantity(allocatedQuantity);
					if(status.equals("1")) {
						res.setStatus("Pending");
					}
					else {
						res.setStatus("Executed");
					}
					
					
				}
					
					rs.close();				
				
				System.out.println("Connection closed...");

			}
			catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} 
			catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			
			return res;
}
				
			
//		Following method returns a block 		
		public List<Order> retrieveBlock(String blockID) {
		List<Order> blockOrders = new ArrayList<Order>();
		
		Connection conn = null;
		
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			java.sql.PreparedStatement stmt = (PreparedStatement) conn.prepareStatement(
					"select * from equity.order a \r\n" + 
					"join \r\n" + 
					"equity.block_order b\r\n" + 
					"on a.OrderID = b.OrderID\r\n" + 
					"join \r\n" + 
					"equity.block_details c\r\n" + 
					"on b.BlockID = c.Block_ID\r\n" + 
					"where c.Block_ID = ?");
			stmt.setString(1, blockID);
			//System.out.println(stmt);
			ResultSet rs = stmt.executeQuery();
			
			/*
			String orderId, String symbol, String side, String type, int totalQuantity, 
			String stockName, String manager, String porfolioId, int allocatedQuantity,
			float actualPrice, Date timeCreated,float limitPrice, float stopPrice
			*/
			while(rs.next()) {
				String orderId = rs.getString("OrderID");
				String symbol = rs.getString("Symbol");
				String side = rs.getString("Side");
				if( side.equals("0")) {
					side = "Buy";
				}
				else {
					side = "Sell";
				}
				String type = rs.getString("Type");
				if( type.equals("0")) {
					type = "GTD";
				}
				else {
					type = "GTC";
				}
				int totalQuantity = rs.getInt("Total_Quantity");
				String stockName = rs.getString("Stock_Name");
				float limitPrice = rs.getFloat("Limit_Price");
				float stopPrice = rs.getFloat("Stop_Price");
				String manager = rs.getString("Manager");
				String porfolioId = rs.getString("Portfolio_ID");
				int openQuantity = rs.getInt("Open_Quantity");
				int allocatedQuantity = rs.getInt("Allocated_Quantity");
				String status = rs.getString("Status");
				if( status.equals("0")) {
					status = "Pending";
				}
				else {
					status = "Completed";
				}
				float actualPrice = rs.getFloat("Actual_Price");
				Date timeCreated = rs.getDate("Time_Created");
				Date timeExecuted = rs.getDate("Time_executed");
				Order order = new Order(orderId, symbol, side, type, totalQuantity, stockName, manager, porfolioId,
										allocatedQuantity, actualPrice, timeCreated, limitPrice, stopPrice);
				order.setTimeExecuted(timeExecuted);
				blockOrders.add(order);
				
			}
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
