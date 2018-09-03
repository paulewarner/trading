package com.sapient.trading.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	Connection conn;

	Connection currentConn = null;
	public Connection getConnection()
	{
		try
		{
			String url = "jdbc:mysql://localhost:3306/equity";
			String uname = "root";
			String pwd = "Sapient123";

			Class.forName("com.mysql.jdbc.Driver");
			try
			{
				conn = DriverManager.getConnection(url,uname,pwd);
			}
			catch (SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e);
		}
		return conn;
}

}
