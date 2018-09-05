package com.sapient.trading.repos;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import com.sapient.trading.helper.ConnectionManager;
import com.sapient.trading.models.Order;

public class OrderCreationRepo {

	
	PreparedStatement stmt = null;
	int rs;
	boolean res= true;

	public boolean saveOrder(Order order) {
		
		Connection conn = ConnectionManager.getConnection();
		try {
			stmt = (PreparedStatement) conn.prepareStatement("INSERT into equity.order (OrderID, Symbol, Side, Type,"
					+ "Total_Quantity, Stock_Name, Limit_Price, Stop_Price, Manager, Portfolio_ID, Status, Time_Created)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, order.getOrderId());
			stmt.setString(2, order.getSymbol());
			if(order.getSide().equals("Buy")) {
				stmt.setInt(3,0);	
			}
			else {
				stmt.setInt(3,1);
			}
			
			if(order.getType().equals("gtc")) {
				stmt.setInt(4,0);	
			}
			else {
				stmt.setInt(4,1);
			}
			stmt.setInt(5, order.getTotalQuantity());
			stmt.setString(6, order.getStockName());
			stmt.setFloat(7, order.getLimitPrice());
			stmt.setFloat(8, order.getStopPrice());
			stmt.setString(9, order.getManager());
			stmt.setString(10, order.getportfolioID());
			stmt.setInt(11,0);
			stmt.setDate(12, order.getTimeCreated());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}
		
		
		try {
			rs = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}
		
		
		System.out.println("Connection closed...");
	
		return res;

	}
}