package com.ryan.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ryan.beans.Users;
import com.ryan.core.bom.Database;

public class UsersDao {
	
	private Database database;
	private Connection connection;
	
	public UsersDao() {
		this.database = Database.getInstance();
		this.connection = this.database.getConnection();
	}
	
	public ArrayList<Users> retrieveAll() throws SQLException {		
		String sql = "select * from users";				
		return buildUserObjectArray(getResultSet(sql));		
	}

	private ArrayList<Users> buildUserObjectArray(ResultSet rs)	throws SQLException {
		ArrayList<Users> users = new ArrayList<Users>();
		
		while(rs.next()) {
			users.add(new Users(rs.getLong("user_id"), rs.getString("username"), rs.getString("password")));
		}
		return users;
	}

	private ResultSet getResultSet(String sql) throws SQLException {
		Statement stmt = this.connection.createStatement();
		return stmt.executeQuery(sql);
	}
}
