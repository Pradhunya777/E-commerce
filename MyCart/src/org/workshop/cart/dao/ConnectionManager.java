package org.workshop.cart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	//private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String URL = "jdbc:mysql://localhost:3306/mycart";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";

	public static Connection openConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
