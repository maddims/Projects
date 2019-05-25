package com.hex.bekary.service;

import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.hex.bekary.beans.CartBean;

class ViewOrderServiceTest {

	static BekaryService viewOrderService;
	static Map<String,CartBean> shippableOrder;
	
	@BeforeAll
	static void init() {
		CartBean product = new CartBean();
		product.setItemCode("VS5");
		product.setQuantity("10");
		product.setTotalCost("20.0");
		shippableOrder=new HashMap<>();
		shippableOrder.put("VS5", product);		
	}
	
	@Test
	public void testViewFinalOrder() {
		viewOrderService = Mockito.mock(ViewOrderService.class);
		viewOrderService.viewFinalOrder(shippableOrder);
		verify(viewOrderService).viewFinalOrder(shippableOrder);
		verify(viewOrderService,Mockito.times(1)).viewFinalOrder(shippableOrder);
	}

}
