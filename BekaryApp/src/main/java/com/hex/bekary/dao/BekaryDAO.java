package com.hex.bekary.dao;

import java.util.Map;

public interface BekaryDAO {
	
	public Map<String,Double> getPackagesWithPrices();
	public Map<String,Integer[]> getAvailablePackagesPerItem();

}
