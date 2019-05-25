package com.hex.bekary.main;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hex.bekary.beans.CartBean;
import com.hex.bekary.beans.ProductBean;
import com.hex.bekary.buslogic.PackageAllocationServiceImpl;
import com.hex.bekary.exceptions.BekaryAppException;
import com.hex.bekary.input.AcceptInput;
import com.hex.bekary.service.BekaryService;
import com.hex.bekary.service.BekaryServiceImpl;
import com.hex.bekary.service.ShippingSpaceService;
import com.hex.bekary.service.ViewOrderService;

public class BekaryApp{
	public static Logger log = LogManager.getLogger();
	
	public static void main(String args[])
	{
		log.info("Start: Bekary Application");
		try {
		PackageAllocationServiceImpl packageAllocationService = new PackageAllocationServiceImpl();
		BekaryService bekaryService = new BekaryServiceImpl();
		ShippingSpaceService shippingSpaceService = new ShippingSpaceService();
		ViewOrderService viewOrderService = new ViewOrderService();
		
		Map<String,ProductBean> inputOrder = AcceptInput.takeInputOrder();
		
		Map<String,Integer[]> availablePackages = bekaryService.getAvailablePackagesPerItem();
		Map<String,List<Integer>> minimumPackagesAllocatedPerItem = new LinkedHashMap<>();
		inputOrder.forEach((product,order) -> {
			List<Integer> packBreakDown = packageAllocationService.minimumPackagesToBeAllocated((int)order.getQuantity(),availablePackages.get(order.getItemCode()));
			minimumPackagesAllocatedPerItem.put(product, packBreakDown);
		});
		
		Map<String,CartBean> shippableOrder = shippingSpaceService.prepareOrder(minimumPackagesAllocatedPerItem,inputOrder);
		viewOrderService.viewFinalOrder(shippableOrder);
		
		log.info("End: Bekary Application");
		}
		catch (BekaryAppException bae) {
			log.error("Error occured in Bekary Application with reason: "+ bae.getLocalizedMessage());
		}
	}
	
}
		 



