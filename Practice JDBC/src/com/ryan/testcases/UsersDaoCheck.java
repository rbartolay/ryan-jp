package com.ryan.testcases;

import static org.junit.Assert.*;

import org.junit.Test;
import com.ryan.dao.UsersDao;

public class UsersDaoCheck {
	
	private UsersDao uDao;
	
	public UsersDaoCheck() {
		this.uDao = new UsersDao();
	}
	
	@Test
	public void checkIfUsersRetrieved() {
		assertNotNull(uDao.retrieveAll());
	}
	
	@Test
	public void checkIfEmailExists() {
		assertNotNull(uDao.retrieveByEmail("es"));
	}
	
	@Test
	public void checkIfEmailNotExists() {
		assertNull(uDao.retrieveByEmail("fuck"));
	}
}
