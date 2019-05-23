package com.hex.bekary.main;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hex.bekary.beans.CartBean;
import com.hex.bekary.buslogic.PackageAllocationService;
import com.hex.bekary.input.AcceptInput;
import com.hex.bekary.service.BekaryService;
import com.hex.bekary.service.BekaryServiceImpl;
import com.hex.bekary.service.ShippingSpaceService;

public class BekaryApp{
	public static Logger log = LogManager.getLogger();
	
	public static void main(String args[])
	{
		log.info("Start: Bekary Application");
		
		PackageAllocationService packageAllocationService = new PackageAllocationService();
		BekaryService bekaryService = new BekaryServiceImpl();
		ShippingSpaceService shippingSpaceService = new ShippingSpaceService();
		
		Map<String,CartBean> inputOrder = AcceptInput.takeInputOrder();
		

		Map<String,Integer[]> availablePackages = bekaryService.getAvailablePackagesPerItem();
		Map<String,List<Integer>> minimumPackagesAllocatedPerItem = new LinkedHashMap<>();
		inputOrder.forEach((product,order) -> {
			List<Integer> packBreakDown = packageAllocationService.minimumPackagesToBeAllocated((int)order.getQuantity(),availablePackages.get(order.getItemCode()));
			minimumPackagesAllocatedPerItem.put(product, packBreakDown);
		});
		
		//This object will have all the details using which we can customize the format
		Map<String,CartBean> shippableOrder = shippingSpaceService.prepareOrder(minimumPackagesAllocatedPerItem,inputOrder);
		
		log.info("End: Bekary Application");
	}
	
}
		 



