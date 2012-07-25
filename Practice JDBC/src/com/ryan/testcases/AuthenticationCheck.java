package com.ryan.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ryan.bom.AuthenticationBom;

public class AuthenticationCheck {
	
	private AuthenticationBom auth;
	
	public AuthenticationCheck() {
		auth = new AuthenticationBom();
	}
	
	@Test
	public void checkIfLoginSuccess() {		
		assertNotNull(auth.login("es", "123456"));
	}
	
	@Test
	public void checkIfLoginFails() {
		assertNull(auth.login("es", "fuck"));
	}
}
