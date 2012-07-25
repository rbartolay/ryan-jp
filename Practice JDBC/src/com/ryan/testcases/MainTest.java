package com.ryan.testcases;

import junit.framework.TestCase;

import org.junit.Test;

import com.ryan.core.bom.Database;

public class MainTest extends TestCase {
	
	private Database database;
	
	public MainTest() {
		this.database = Database.getInstance();
	}
	
	public void testDatabaseIfNull() {
		assertNull(Database.getInstance());
	}
	
}
