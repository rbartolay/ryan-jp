package com.ryan.core.bom;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Database {
	
	private static Database database = null;
	private Connection connection;
	
	private Database() {
		try {
			CallDatabasePackage();
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/jee", "root", "");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void CallDatabasePackage() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public static Database getInstance() {
		
		if(database == null) {
			database = new Database();
		}
		
		return null;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Database(Connection connection) {
		super();
		this.connection = connection;
	}
}
