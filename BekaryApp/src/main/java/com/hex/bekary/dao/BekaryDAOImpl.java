package com.hex.bekary.dao;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.hex.bekary.exceptions.BekaryAppException;
import com.hex.bekary.util.Items;
import com.hex.bekary.util.Packages;
import com.hex.bekary.util.PackagesWithPrice;

public class BekaryDAOImpl implements BekaryDAO{

	/**
	 * Mocking the data object instead of fetching from database
	 * To do: database objects implementation
	 */
	
	@Override
	public Map<String, Double> getPackagesWithPrices() {
		
		Map<String,Double> packagesWithPrice = new LinkedHashMap<>();
		packagesWithPrice.put(PackagesWithPrice.VS5_3.toString(), PackagesWithPrice.VS5_3.getPrice());
		packagesWithPrice.put(PackagesWithPrice.VS5_5.toString(), PackagesWithPrice.VS5_5.getPrice());
		packagesWithPrice.put(PackagesWithPrice.MB11_2.toString(), PackagesWithPrice.MB11_2.getPrice());
		packagesWithPrice.put(PackagesWithPrice.MB11_5.toString(), PackagesWithPrice.MB11_5.getPrice());
		packagesWithPrice.put(PackagesWithPrice.MB11_8.toString(), PackagesWithPrice.MB11_8.getPrice());
		packagesWithPrice.put(PackagesWithPrice.CF_3.toString(), PackagesWithPrice.CF_3.getPrice());
		packagesWithPrice.put(PackagesWithPrice.CF_5.toString(), PackagesWithPrice.CF_5.getPrice());
		packagesWithPrice.put(PackagesWithPrice.CF_9.toString(), PackagesWithPrice.CF_9.getPrice());
		
		if(packagesWithPrice.isEmpty()){
			throw new BekaryAppException("Packages&Prices weren't fetched, prices seems to be null");
		}
		return packagesWithPrice;
	}

	@Override
	public Map<String, Integer[]> getAvailablePackagesPerItem() {
		
		Map<String, Integer[]> availablePackagesPerItem = new HashMap<>();
		availablePackagesPerItem.put(Items.VS5.toString(), new Integer[] {Packages.PKG_3.getPackage(),Packages.PKG_5.getPackage()});
		availablePackagesPerItem.put(Items.MB11.toString(), new Integer[] {Packages.PKG_2.getPackage(),Packages.PKG_5.getPackage(),Packages.PKG_8.getPackage()});
		availablePackagesPerItem.put(Items.CF.toString(), new Integer[] {Packages.PKG_3.getPackage(),Packages.PKG_5.getPackage(),Packages.PKG_9.getPackage()});
		if(availablePackagesPerItem.isEmpty()){
			throw new BekaryAppException("No Packages are Available");
		}
		return availablePackagesPerItem;
	}

}
