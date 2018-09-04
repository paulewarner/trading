package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sapient.trading.helper.ConnectionManager;

public class PortfolioRetrieveRepo {

	Connection conn = null;
	List<String> list;
	ResultSet rs = null;
	Statement stmt = null;
	public List<String> retrieveList(String manager) {
		conn = ConnectionManager.getConnection();
		
		list = new ArrayList<>();
		
		String sql = "SELECT Portfolio_ID FROM equity.portfolio_user WHERE UserID = '" + manager + "' ";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				
				list.add(rs.getString("Portfolio_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	
}
