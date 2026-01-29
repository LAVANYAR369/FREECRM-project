package com.crm.FreeCRMTest.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


public class DatabaseUtility {
	Connection conn;
	public void getDataBaseConnection(String url,String username,String password)
	{
		try {
			Driver dri=new Driver();
			DriverManager.registerDriver(dri);
			conn=DriverManager.getConnection(url, username, password);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public void closeDBConnection()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
public ResultSet getExecuteQuery(String query) throws Throwable
{
	ResultSet result=null;
	Statement stat=conn.createStatement();
	result=stat.executeQuery(query);
	
	return result;
	
}
}
