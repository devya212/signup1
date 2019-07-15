package com.nucleus.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	
	public Connection getDbConnection()
	{
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return con;	
	}

}
