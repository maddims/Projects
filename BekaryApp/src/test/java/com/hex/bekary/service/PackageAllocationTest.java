package com.hex.bekary.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hex.bekary.service.BekaryService;

public class PackageAllocationTest {

	public BekaryService bekaryService;
	Integer noOfItemsOrdered;
	Integer[] packagesAvailable;
	
	@Before
	public void init() {
		bekaryService = new BekaryServiceImpl();
		noOfItemsOrdered = 10;
		packagesAvailable = new Integer[]{2,5,3};
		
	}
	
	@Test
	public void testMinumumPackagesToBeAllocatedWithValidInput() {
		
		List<Integer> minimumPackgesCalculated;
		minimumPackgesCalculated = bekaryService.minimumPackagesToBeAllocated(noOfItemsOrdered, packagesAvailable);
		assertNotNull(minimumPackgesCalculated);
		assertEquals(2, minimumPackgesCalculated.size());		
	}
	
	@Test(expected=NullPointerException.class)
	public void testMinumumPackagesToBeAllocatedWithInValidInput() {
		
		List<Integer> minimumPackgesCalculated;
		minimumPackgesCalculated = bekaryService.minimumPackagesToBeAllocated(noOfItemsOrdered, null);
		assertNull(minimumPackgesCalculated);
		assertEquals(0, minimumPackgesCalculated.size());	
		
	}
	
}
