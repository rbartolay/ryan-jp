package com.ryan.runtime;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.ryan.beans.Users;
import com.ryan.core.bom.Database;
import com.ryan.dao.UsersDao;

public class Main {
	
	private static UsersDao uDao;
	
	public static void main(String[] args) {
		uDao = new UsersDao();
		try {
			iterateUsers(uDao.retrieveAll());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void iterateUsers(ArrayList<Users> users) throws SQLException {
		users = uDao.retrieveAll();
		for(Iterator<Users> i = users.iterator(); i.hasNext();) {
			Users user = i.next();
			System.out.println(i.toString());
		}
	}
}
