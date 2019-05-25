package com.hex.bekary.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hex.bekary.beans.CartBean;
import com.hex.bekary.beans.ProductBean;

class ShippingSpaceServiceTest {

	static BekaryService shippingSpaceService;
	static Map<String, List<Integer>> minimumPackagesAllocatedPerItem;
	static Map<String,ProductBean> inputOrder;
	
	@BeforeAll
	static void init() {
		shippingSpaceService = new ShippingSpaceService();
		ProductBean product = new ProductBean();
		product.setItemCode("VS5");
		product.setQuantity(10);
		product.setTotalCost(20.0);
		minimumPackagesAllocatedPerItem = new HashMap<>();
		inputOrder=new HashMap<>();
		inputOrder.put("VS5", product);
		minimumPackagesAllocatedPerItem.put("VS5", Arrays.asList(5,5));
		
	}
	
	@Test
	void testPrepareOrder() {
		Map<String, CartBean> shippableOrder = shippingSpaceService.prepareOrder(minimumPackagesAllocatedPerItem, inputOrder);
		assertNotNull(shippableOrder);
	}

}
