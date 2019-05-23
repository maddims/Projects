package com.hex.bekary.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.hex.bekary.beans.CartBean;
import com.hex.bekary.util.PackagesWithPrice;

public class ShippingSpaceService {

	public Map<String, CartBean> prepareOrder(Map<String, List<Integer>> minimumPackagesAllocatedPerItem,
			Map<String, CartBean> inputOrder) {
		
		Map<String, CartBean> shippableBean = new LinkedHashMap<>();
		inputOrder.forEach((itemCode, orderBean)-> {
			String itemDescription =  "";
			Double totalCost = 0.0;
			for(Integer pkg:minimumPackagesAllocatedPerItem.get(itemCode))
			{
				String code= itemCode+"_"+pkg;
				totalCost = + PackagesWithPrice.valueOf(code).getPrice();
			}
			
			orderBean.setDescription(itemDescription);
			orderBean.setTotalCost(totalCost);
			shippableBean.put(itemCode, orderBean);
		});
		
		return null;
		
	}
	
}
