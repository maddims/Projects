package com.hex.bekary.buslogic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hex.bekary.exceptions.BekaryAppException;

public class PackageAllocationServiceImpl implements PackageAllocationService{

	public static Logger log = LogManager.getLogger();

	
	public List<Integer> minimumPackagesToBeAllocated(int noOfItemsOrdered, Integer[] packages) {
		
		Integer minimumPackagesPossibleForTotalPackages[] = new Integer[noOfItemsOrdered + 1];
    	Integer packagesUsedToGetToal[] = new Integer[noOfItemsOrdered + 1];
        minimumPackagesPossibleForTotalPackages[0] = 0;
    
        if(packages==null) {
        	log.error("Empty packages found");
        	throw new BekaryAppException("Empty packages found");
        }
        for(int possiblePackagesCount=1; possiblePackagesCount <= noOfItemsOrdered; possiblePackagesCount++){
            minimumPackagesPossibleForTotalPackages[possiblePackagesCount] = Integer.MAX_VALUE-1;
            packagesUsedToGetToal[possiblePackagesCount] = -1;
        }
        for(int pkg=0; pkg < packages.length; pkg++){
            for(int possiblePackagesCount=1; possiblePackagesCount <= noOfItemsOrdered; possiblePackagesCount++){
                if(possiblePackagesCount >= packages[pkg]){
                	int minPackagesToGetEachTotal=minimumPackagesPossibleForTotalPackages[possiblePackagesCount - packages[pkg]] + 1;
                    if (minPackagesToGetEachTotal < minimumPackagesPossibleForTotalPackages[possiblePackagesCount]) {
                        minimumPackagesPossibleForTotalPackages[possiblePackagesCount] = minPackagesToGetEachTotal;
                        packagesUsedToGetToal[possiblePackagesCount] = pkg;
                    }
                    else if(minPackagesToGetEachTotal == minimumPackagesPossibleForTotalPackages[possiblePackagesCount]) {
                    	if(packagesUsedToGetToal[possiblePackagesCount] < packages[pkg]);
                    	packagesUsedToGetToal[possiblePackagesCount] = pkg;
                    }
                }
            }
        }
        return getNoOfPackagesAndPackageValues(packagesUsedToGetToal,packages);
	}
	
	
	public List<Integer> getNoOfPackagesAndPackageValues(Integer minimumPackagesPossible[], Integer packages[]) {
    	List<Integer> minumPackagesToBeAllocated = new ArrayList<>();
    	if (minimumPackagesPossible[minimumPackagesPossible.length - 1] == -1) {
            log.info("Packages can't be allocated");
            return null;
        }
        int start = minimumPackagesPossible.length - 1;
        while ( start != 0 ) {
            int pkg = minimumPackagesPossible[start];
            minumPackagesToBeAllocated.add(packages[pkg]);
            start = start - packages[pkg];
        }
        return minumPackagesToBeAllocated;
    }

}
