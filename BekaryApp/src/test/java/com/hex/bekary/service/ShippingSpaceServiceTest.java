package com.hex.bekary.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.hex.bekary.beans.CartBean;
import com.hex.bekary.beans.ProductBean;
import com.hex.bekary.buslogic.PackageAllocationService;
import com.hex.bekary.buslogic.PackageAllocationServiceImpl;

class ShippingSpaceServiceTest {


	static BekaryService shippingSpaceService;
	static BekaryService bekaryService;
	static PackageAllocationService packageAllocationService;
	static Map<String, List<Integer>> minimumPackagesAllocatedPerItem;
	static Map<String,ProductBean> inputOrder;
	
	@BeforeAll
	static void init() {
		shippingSpaceService = new ShippingSpaceService();
		bekaryService = new BekaryServiceImpl();
		packageAllocationService = new PackageAllocationServiceImpl();
		minimumPackagesAllocatedPerItem = new HashMap<>();
		inputOrder=new HashMap<>();
		setUpData();
		
	}
	
	@Test
	void testPrepareOrder() {
		Map<String, CartBean> shippableOrder = shippingSpaceService.prepareOrder(minimumPackagesAllocatedPerItem, inputOrder);
		assertNotNull(shippableOrder);
	}
	
	@Test
	void testPrepareOrderWithFullSetData() {
		Map<String, CartBean> shippableOrder = shippingSpaceService.prepareOrder(minimumPackagesAllocatedPerItem, inputOrder);
		CartBean product_MB11 = shippableOrder.get("MB11");
		List<String> priceBreakDown= Arrays.asList("1 x 8 $24.95","3 x 2 $9.95");
		assertEquals("54.8", product_MB11.getTotalCost());
		assertEquals(priceBreakDown, product_MB11.getPriceBreakDown());
	}
	
	private static void setUpData() {
		ProductBean product_VS5 = new ProductBean("Vegemite Scroll", "VS5", 10);
		ProductBean product_MB11 = new ProductBean("Blueberry Muffin", "MB11", 14);
		ProductBean product_CF= new ProductBean("Croissant", "CF", 13);
		inputOrder.put("VS5",product_VS5);
		inputOrder.put("MB11",product_MB11);
		inputOrder.put("CF",product_CF);

		Map<String,Integer[]> availablePackages = bekaryService.getAvailablePackagesPerItem();
		inputOrder.forEach((product,order) -> {
			List<Integer> packBreakDown = packageAllocationService.minimumPackagesToBeAllocated((int)order.getQuantity(),availablePackages.get(order.getItemCode()));
			minimumPackagesAllocatedPerItem.put(product, packBreakDown);
		});
	}

}
