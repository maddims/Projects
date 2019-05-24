package com.hex.bekary.service;

import java.util.Map;

import com.hex.bekary.dao.BekaryDAO;
import com.hex.bekary.dao.BekaryDAOImpl;

public class BekaryServiceImpl implements BekaryService {

	@Override
	public Map<String, Double> getPackagesWithPrices() {
		BekaryDAO bekaryDAO = new BekaryDAOImpl();
		return bekaryDAO.getPackagesWithPrices();
	}
	
	@Override
	public Map<String,Integer[]> getAvailablePackagesPerItem() {
		BekaryDAO bekaryDAO = new BekaryDAOImpl();
		return bekaryDAO.getAvailablePackagesPerItem();
	}
	
}
