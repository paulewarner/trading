package com.sapient.trading.repos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.sapient.trading.models.Authority;
import com.sapient.trading.models.EncryptedPass;
import com.sapient.trading.models.User;





@Component
public class UserRepository  {
	
	public static void main(String[] args) {
/*		List<User> courses = new UserRepository().findAllUsers();
		System.out.println(courses);*/
	}
	
// / JDBC driver name and database URL
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost:3307/cogdb";
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

	static final String DB_URL = "jdbc:mysql://localhost:3307/cogdb";

	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	public int findAllUsers(String enteredUserId,String enteredPassword) {
		
		Connection conn = null;
		Statement stmt = null;
		List<User> users = new ArrayList<User>();
		List<Authority> userAuthorities = new ArrayList<Authority>();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");
			//Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			
			
			String sqlUserData =  "SELECT userId, username, password, enabled FROM users";
			String sqlAuthorityData = "SELECT userId, authority FROM authorities";
			
			ResultSet rs = stmt.executeQuery(sqlUserData);
			
			boolean userPresence = false;
			
			while (rs.next()) {
				// Retrieve by column name
				String userId = rs.getString("userId");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int enabled = rs.getInt("enabled");
				
				
				User retrievedUser = new User(userId, username, password,enabled);
				users.add(retrievedUser );
				
				if  (userId.equals(enteredUserId)){
					userPresence = true;
					if( new EncryptedPass().checkPass(enteredPassword, password))
						return 1;
					else 
						return 2;
					

				}
			}		
			ResultSet rs2 = stmt.executeQuery(sqlAuthorityData);
			while (rs2.next()) {
				// Retrieve by column name
				String userId = rs.getString("userId");
				String authority = rs.getString("authority");
				Authority retrievedUserAuthority = new Authority(userId, authority);
				userAuthorities.add(retrievedUserAuthority);
			}
			rs.close();
			rs2.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

			return 0;
		
		
	}
	public void addUser(String userId,String username,String password,String authority){
		
		password = new EncryptedPass().hashPassword(password);
		Connection conn = null;
		//Statement stmt = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connecting to a selected database...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("Connected database successfully...");


			System.out.println("Creating statement...");
			//stmt = conn.createStatement();
			
		    String sqlUserData = " insert into users (userId, username, password, enabled)"
		    	        + " values (?, ?, ?, ?)";		    
		    PreparedStatement preparedStmt = conn.prepareStatement(sqlUserData);
		    preparedStmt.setString (1, userId);
		    preparedStmt.setString (2, username);
		    preparedStmt.setString (3, password);
		    preparedStmt.setInt (4, 1);
		    preparedStmt.execute();
		    
		    String sqlAuthorityStatement = " insert into authorities (userId, authority)"
	    	        + " values (?, ?)";	
		    preparedStmt = conn.prepareStatement(sqlAuthorityStatement);
		    preparedStmt.setString (1, userId);
		    preparedStmt.setString (2, authority);
		    preparedStmt.execute();		    
		    conn.close();	
		
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		
		
	}

	

}
