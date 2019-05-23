package com.hex.bekary.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.hex.bekary.buslogic.PackageAllocationService;

public class PackageAllocationTest {

	public PackageAllocationService packageAllocationService;
	Integer noOfItemsOrdered;
	Integer[] packagesAvailable;
	
	@Before
	public void init() {
		packageAllocationService = new PackageAllocationService();
		noOfItemsOrdered = 10;
		packagesAvailable = new Integer[]{2,5,3};
		
	}
	
	@Test
	public void testMinumumPackagesToBeAllocatedWithValidInput() {
		
		List<Integer> minimumPackgesCalculated;
		minimumPackgesCalculated = packageAllocationService.minimumPackagesToBeAllocated(noOfItemsOrdered, packagesAvailable);
		assertNotNull(minimumPackgesCalculated);
		assertEquals(2, minimumPackgesCalculated.size());		
	}
	
	@Test(expected=NullPointerException.class)
	public void testMinumumPackagesToBeAllocatedWithInValidInput() {
		
		List<Integer> minimumPackgesCalculated;
		minimumPackgesCalculated = packageAllocationService.minimumPackagesToBeAllocated(noOfItemsOrdered, null);
		assertNull(minimumPackgesCalculated);
		assertEquals(0, minimumPackgesCalculated.size());	
		
	}
	
}
