package com.ryan.core.bom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static Database database = null;
	private Connection connection;
	
	private Database() {
		try {
			CallDatabasePackage();
			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bchv2", "root", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private void CallDatabasePackage() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Database getInstance() {
		
		if(database == null) {
			database = new Database();
		}
		
		return database;
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
