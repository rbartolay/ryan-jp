package com.ryan.testcases;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ryan.beans.Users;
import com.ryan.dao.UsersDao;

import junit.framework.TestCase;

public class UsersDaoCheck extends TestCase {
	
	private UsersDao uDao;
	
	public UsersDaoCheck() {
		this.uDao = new UsersDao();
	}
	
	public void testNotNull() throws SQLException {
		assertNotNull(this.uDao.retrieveAll());
	}
}
