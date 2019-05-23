package com.hex.bekary.service;


import java.util.Map;


public interface BekaryService {

	Map<String, Double> getPackagesWithPrices();
	
	Map<String, Integer[]> getAvailablePackagesPerItem();
}
