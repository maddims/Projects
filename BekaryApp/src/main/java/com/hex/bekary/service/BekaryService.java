package com.hex.bekary.service;


import java.util.List;
import java.util.Map;

import com.hex.bekary.beans.CartBean;
import com.hex.bekary.beans.ProductBean;


public interface BekaryService {

	default Map<String, Double> getPackagesWithPrices(){return null;};
	
	default Map<String, Integer[]> getAvailablePackagesPerItem(){return null;};
	
	default Map<String, CartBean> prepareOrder(Map<String, List<Integer>> minimumPackagesAllocatedPerItem,
			Map<String, ProductBean> inputOrder){return null;};
			
	default Map<Integer,Integer> countNoOfPackagesPerPackage(List<Integer> list){
		return null;
	}
	
	default void viewFinalOrder(Map<String, CartBean> shippableOrder) {};
}
