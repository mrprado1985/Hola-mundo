package com.revature.test;

import static org.junit.Assert.*;
import org.junit.Test;

import com.revature.dao.ManagerDao;
import com.revature.dao.ManagerDaoImpl;

public class getManagerShouldReturnManager {

	@Test
	public void testGetManager() {
		ManagerDao md = new ManagerDaoImpl();
		assertTrue("No manager returned", md.getManager("prado", "password") != null);
	}
}
