package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;
import com.sapient.trading.models.Block;
import com.sapient.trading.models.EquityResponse;
import com.sapient.trading.models.Order;

@Repository
public class ExecMgmtSysRepo {
	
	private Block block;
	private Order order;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/equity";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "rootroot";
	
	public boolean orderUpdate(Order newOrder, EquityResponse eqResponse) {
		
		return true;
	}
	
	public boolean blockUpdate(Block block, EquityResponse eqResponse) {
		
		return true;
	}
	
	public List<Order> retrieveBlock(Block block) {
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
			PreparedStatement stmt = (PreparedStatement) conn.prepareStatement("SELECT * from equity.order a");
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
