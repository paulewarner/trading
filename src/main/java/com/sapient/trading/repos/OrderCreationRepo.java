package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;
import com.sapient.trading.helper.ConnectionManager;
import com.sapient.trading.models.Order;

public class OrderCreationRepo {

	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	boolean res= true;
//	public static void main(String args[]) {
//		Date timeCreated = new Date(System.currentTimeMillis());
//		Order order = new Order("123", "APPL", "Buy", "GTD", 12, "Apple", 
//				"manager", "21212", 2, 343.34f, timeCreated, 44.67f, 23.78f);
//		OrderCreationRepo ocr = new OrderCreationRepo();
//		System.out.println(ocr.saveOrder(order));
//	}
	public boolean saveOrder(Order order) {
		
		Connection conn = ConnectionManager.getConnection();
		try {
			stmt = (PreparedStatement) conn.prepareStatement("INSERT into equity.order (OrderID, Symbol, Side, Type,"
					+ "Total_Quantity, Stock_Name, Limit_Price, Stop_Price, Manager, Portfolio_ID, Status, Time_Created)"
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, order.getOrderId());
			stmt.setString(2, order.getSymbol());
			stmt.setString(3, order.getSide());
			stmt.setString(4, order.getType());
			stmt.setInt(5, order.getTotalQuantity());
			stmt.setString(6, order.getStockName());
			stmt.setFloat(7, order.getLimitPrice());
			stmt.setFloat(8, order.getStopPrice());
			stmt.setString(9, order.getManager());
			stmt.setString(10, order.getportfolioID());
			stmt.setString(11, order.getStatus());
			stmt.setDate(12, order.getTimeCreated());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}
		
		
		try {
			rs = stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}
		
		
		System.out.println("Connection closed...");
	
		return res;

	}
}
