package com.hex.bekary.buslogic;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hex.bekary.exceptions.BekaryAppException;

class PackageAllocationServiceTest {

	static PackageAllocationService packageAllocationService;
	static Integer noOfItemsOrdered;
	static Integer[] packagesAvailable;
	
	@BeforeAll
	static void init() {
		packageAllocationService = new PackageAllocationServiceImpl();
		noOfItemsOrdered = 10;
		packagesAvailable = new Integer[]{2,5,3};		
	}
	
	@Test
	public void testMinumumPackagesToBeAllocatedWithValidInput() {
		
		List<Integer> minimumPackgesCalculated;
		minimumPackgesCalculated = packageAllocationService.minimumPackagesToBeAllocated(noOfItemsOrdered, packagesAvailable);
		assertNotNull(minimumPackgesCalculated);
		assertEquals(2, minimumPackgesCalculated.size());
		assertEquals(new ArrayList<Integer>(Arrays.asList(5,5)), minimumPackgesCalculated);
	}
	
	@Test
	public void testMinumumPackagesToBeAllocatedWithInValidInput() {
		
		assertThrows(BekaryAppException.class,() -> packageAllocationService.minimumPackagesToBeAllocated(noOfItemsOrdered, null));	
		
	}

}
