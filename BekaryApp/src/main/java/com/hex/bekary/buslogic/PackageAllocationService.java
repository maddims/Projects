package com.hex.bekary.buslogic;

import java.util.List;

public interface PackageAllocationService {

	List<Integer> minimumPackagesToBeAllocated(int noOfItemsOrdered, Integer[] packages);
	List<Integer> getNoOfPackagesAndPackageValues(Integer minimumPackagesPossible[], Integer packages[]);
	
}
