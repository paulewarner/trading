
package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sapient.trading.models.PortfolioContent;
@Repository
public class PortfolioContentRepo {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3307/equity";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";
	List<PortfolioContent> portfoliocontents = new ArrayList<PortfolioContent>();

	public List<PortfolioContent> getlistoforders(String testportfolioidid) {
		Connection conn = null;
		Statement stmt = null;
		List<PortfolioContent> portfoliocontents = new ArrayList<PortfolioContent>();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();

			String sql = "SELECT  *\r\n" + 
					"FROM equity.order b\r\n" + 
					"where b.Portfolio_ID = " + testportfolioidid;
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while (rs.next()) {
				String id= rs.getString("Portfolio_ID");
				System.out.println(id);
					if(id.equals(testportfolioidid)) {
						
						String symbol= rs.getString("Symbol");
						int quantity= rs.getInt("Total_Quantity");
						int value= rs.getInt("Actual_Price");
						int status= rs.getInt("Status");
						String stockname=rs.getString("Stock_Name");
						String limitprice=rs.getString("Limit_Price");
						String stopprice=rs.getString("Stop_Price");
						String date=rs.getString("Time_Created");
						String orderid = rs.getString("OrderID");
						int allocated=rs.getInt("Open_Quantity");
						int open=rs.getInt("Allocated_Quantity");
						System.out.println(symbol+"\t" 	+ 	quantity+"\t" 	+ 	value+"\t"	+	status);
						
						
						PortfolioContent portfoliocontent = new PortfolioContent(symbol,quantity,value, status, stockname, limitprice, stopprice, date, allocated, open);
						portfoliocontent.setOrderID(orderid);
						portfoliocontents.add(portfoliocontent);
		
					}
			
			}
			
			rs.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}
		
		return portfoliocontents;
	}
}
