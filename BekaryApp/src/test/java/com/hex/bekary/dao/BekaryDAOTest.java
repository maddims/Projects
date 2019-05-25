package com.hex.bekary.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BekaryDAOTest {

	private static BekaryDAO bekaryDAO;
	
	@BeforeAll
	static void init() {
		bekaryDAO=new BekaryDAOImpl();
	}
	
	@Test
	void testGetPackagesWithPrices() {
		Map<String, Double> packagesWithPrices=bekaryDAO.getPackagesWithPrices();
		assertEquals(8, packagesWithPrices.size());
	}
	
	@Test()
	void testAvailablePackagesPerItem() {
		Map<String, Integer[]> availablePackagesPerItem=bekaryDAO.getAvailablePackagesPerItem();
		assertEquals(3, availablePackagesPerItem.size());
		assertNotEquals(0, availablePackagesPerItem.get("VS5"));
		assertEquals(3, availablePackagesPerItem.get("MB11").length);
	}
}
