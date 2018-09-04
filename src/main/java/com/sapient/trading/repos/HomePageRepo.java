
package com.sapient.trading.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.sapient.trading.models.Portfolio1;
import com.sapient.trading.models.PortfolioContent;
import com.sapient.trading.models.UserAndPortfolio;
@Repository
public class HomePageRepo {
	// / JDBC driver name and database URL
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String DB_URL = "jdbc:mysql://localhost:3307/equity";

		// Database credentials
		static final String USER = "root";
		static final String PASS = "root";
		List<UserAndPortfolio> userandportfolios = new ArrayList<UserAndPortfolio>();
		
		List<PortfolioContent> portfoliocontents = new ArrayList<PortfolioContent>();
		List<String> traders;
		Portfolio1 portfolio1;
		
		public HashSet<Portfolio1> getlistofportfolios(String testuserid) {
			Connection conn = null;
			Statement stmt = null;
			HashSet<Portfolio1> portfolio1s = new HashSet<Portfolio1>();
			
			try {
				//  Register JDBC driver
				Class.forName("com.mysql.jdbc.Driver");

				//  Open a connection
				System.out.println("Connecting to a selected database...");
				conn = DriverManager.getConnection(DB_URL, USER, PASS);
				System.out.println("Connected database successfully...");

				//  Execute a query
				System.out.println("Creating statement...");
				stmt = conn.createStatement();
				List<String > portfolioList = new ArrayList<String>();

				String sql = "SELECT * FROM portfolio_user";
				ResultSet rs = stmt.executeQuery(sql);
				
				while (rs.next()) {
					
					String userid = rs.getString("UserID");
					String portid= rs.getString("portfolio_ID");
					if(testuserid.equals(userid)) {
						portfolioList.add(portid);
					}
				}
				System.out.println(portfolioList);
				
				
				String sql1 = "select * from\r\n" + 
						"equity.portfolio_details a\r\n" + 
						"join equity.portfolio_user b\r\n" + 
						"on a.Portfolio_ID = b.Portfolio_ID\r\n" + 
						"where b.UserID = " + testuserid;
				
				for(String portfolioNumber: portfolioList) {
					traders = new ArrayList<String>();
					String portfolioname1 = null,portfoliomanager1 = null;
					ResultSet rs1 = stmt.executeQuery(sql1);
					String  portfoliotradersname = null;
					
			
					while(rs1.next()) {
						System.out.println("portfolioNumber abhinish " + portfolioNumber);
						String portfolioid= rs1.getString("portfolio_ID");
						System.out.println("inside res set " + portfolioid);
						if(portfolioNumber.equals(portfolioid)) {
							System.out.println("inside result set");
							String portfolioname= rs1.getString("Stock_Name");
							String portfoliomanager=rs1.getString("UserID");
							String  portfoliotraders=rs1.getString("UserID");
							String username = rs1.getString("Symbol");
							
							portfolioname1=portfolioname;
							portfoliomanager1=portfoliomanager;
							if(!portfoliotraders.equals(testuserid) && !traders.contains(portfoliotraders)) {
								traders.add(username);
							}
						}
					}
					
					System.out.println(" jan test " + portfolioname1+portfoliomanager1+traders);
					Portfolio1 portfolio1 = new Portfolio1(portfolioNumber,portfolioname1,portfoliomanager1,traders);
					portfolio1s.add(portfolio1);
					rs1.close();
				
				}
				rs.close();
			} catch (SQLException se) {
				// Handle errors for JDBC
				se.printStackTrace();
			} catch (Exception e) {
				// Handle errors for Class.forName
				e.printStackTrace();
			}
			
			return portfolio1s;
		}
		
}


