package com.capgemini.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import com.capgemini.pogo.UserDetails;

public class ConnectionFactory {
	
	public static Connection connection;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:this:@localhost:1521:xe","system","system");
		System.out.println(connection);
		return connection;
	}
	
	public static ArrayList<UserDetails> userDetailsList;
	public static ArrayList getConnectionVer2(){
		userDetailsList=new ArrayList<>();
		return userDetailsList;
	}
	public static void main(String[] args) {
		try {
			System.out.println(ConnectionFactory.getConnection());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
