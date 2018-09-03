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

import com.sapient.trading.helper.ConnectionManager;
import com.sapient.trading.models.Authority;
import com.sapient.trading.models.EncryptedPass;
import com.sapient.trading.models.User;





@Component
public class UserRepository  {
	
	

	private User retrievedUser = null;
	private Authority retrievedUserAuthority = null;
	static Connection currentConn = null;
	static ResultSet rs = null;
	
	public User getUser() {
		return retrievedUser;
	}
	public Authority getAuthority() {
		return retrievedUserAuthority;
	}
	public int findAllUsers(String enteredUserId,String enteredPassword) {
		
		Statement stmt = null;
		List<User> users = new ArrayList<User>();
		List<Authority> userAuthorities = new ArrayList<Authority>();
		try {
			
			currentConn = ConnectionManager.getConnection();
			stmt = currentConn.createStatement();
			
			
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
				
				
				retrievedUser = new User(userId, username, password,enabled);
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
				retrievedUserAuthority = new Authority(userId, authority);
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
		
		//Statement stmt = null;
		try {
			
			currentConn = ConnectionManager.getConnection();
			
			
			
		    String sqlUserData = " insert into users (userId, username, password, enabled)"
		    	        + " values (?, ?, ?, ?)";		    
		    PreparedStatement preparedStmt = currentConn.prepareStatement(sqlUserData);
		    preparedStmt.setString (1, userId);
		    preparedStmt.setString (2, username);
		    preparedStmt.setString (3, password);
		    preparedStmt.setInt (4, 1);
		    preparedStmt.execute();
		    
		    String sqlAuthorityStatement = " insert into authorities (userId, authority)"
	    	        + " values (?, ?)";	
		    preparedStmt = currentConn.prepareStatement(sqlAuthorityStatement);
		    preparedStmt.setString (1, userId);
		    preparedStmt.setString (2, authority);
		    preparedStmt.execute();		    
		    currentConn.close();	
		
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		
		
	}
	
	

	

}
