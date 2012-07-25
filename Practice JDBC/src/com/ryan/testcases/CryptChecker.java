package com.ryan.testcases;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ryan.core.bom.Crypt;

public class CryptChecker {
	
	@Test
	public void checkMd5ReturnNull() {		
		assertNotNull(Crypt.md5("1234"));
	}
}
