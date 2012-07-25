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
	
	public ArrayList<Users> retrieveAll() {		
		String sql = "select * from users";
		try {
			return buildUserObjectArray(this.getResultSet(sql));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	public Users retrieveByEmail(String email) {		
		String sql = "select * from users where email = '"+ email +"'";		
		try {
			return this.buildUserObject(this.getResultSet(sql));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}		
	}
	
	private ArrayList<Users> buildUserObjectArray(ResultSet rs)	throws SQLException {
		ArrayList<Users> users = new ArrayList<Users>();
		
		while(rs.next()) {
			users.add(buildUserObject(rs));
		}
		return users;
	}

	private Users buildUserObject(ResultSet rs) throws SQLException {
		if(rs.next()) {
			return new Users(rs.getLong("user_id"), rs.getString("email"), rs.getString("password"));
		}
		return null;
	}

	private ResultSet getResultSet(String sql) throws SQLException {
		Statement stmt = this.connection.createStatement();
		return stmt.executeQuery(sql);
	}
}
