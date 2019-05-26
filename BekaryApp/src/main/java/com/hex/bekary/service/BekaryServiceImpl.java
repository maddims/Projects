package com.hex.bekary.service;

import java.util.Map;

import com.hex.bekary.dao.BekaryDAO;
import com.hex.bekary.dao.BekaryDAOImpl;
import com.hex.bekary.exceptions.BekaryAppException;

public class BekaryServiceImpl implements BekaryService {

	@Override
	public Map<String, Double> getPackagesWithPrices() throws BekaryAppException {
		BekaryDAO bekaryDAO = new BekaryDAOImpl();
		return bekaryDAO.getPackagesWithPrices();
	}
	
	@Override
	public Map<String,Integer[]> getAvailablePackagesPerItem()throws BekaryAppException {
		BekaryDAO bekaryDAO = new BekaryDAOImpl();
		return bekaryDAO.getAvailablePackagesPerItem();
	}
	
}
