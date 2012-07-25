package com.ryan.runtime;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.ryan.beans.Users;
import com.ryan.bom.AuthenticationBom;
import com.ryan.core.bom.Crypt;
import com.ryan.core.bom.Database;
import com.ryan.dao.UsersDao;

public class Main {
	
	private static UsersDao uDao;
	
	public static void main(String[] args) {
		
	/*	uDao = new UsersDao();
		System.out.println(uDao.retrieveByEmail("es"));*/
		
		AuthenticationBom auth = new AuthenticationBom();
		
		System.out.println(auth.login("es", "fuck"));
		
	}

	private static void iterateUsers(ArrayList<Users> users) throws SQLException {
		users = uDao.retrieveAll();
		for(Iterator<Users> i = users.iterator(); i.hasNext();) {
			Users user = i.next();
			System.out.println(i.toString());
		}
	}
}
