package com.ryan.bom;

import com.ryan.beans.Users;
import com.ryan.dao.UsersDao;

public class AuthenticationBom {

	public Users login(String email, String password) {
		UsersDao uDao = new UsersDao();
		Users user = uDao.retrieveByEmail(email);
		
		if(user != null && user.validateLogin(password)) {
			return user;
		}
		
		return null;
	}
	
}
