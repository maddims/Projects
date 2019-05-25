package com.hex.bekary.service;

import java.util.Map;

import com.hex.bekary.beans.CartBean;

public class ViewOrderService implements BekaryService{

	public void viewFinalOrder(Map<String, CartBean> shippableOrder) {
		
		shippableOrder.forEach((productCode,product) -> {
			System.out.format("%-18s%-4s%-5s%6s", product.getItemName(),product.getQuantity(),product.getItemCode(),product.getTotalCost());
			product.getPriceBreakDown().forEach(priceDetail-> {
				System.out.println();
				System.out.format("%33s",priceDetail);
			});
			System.out.println();
		});
	}

}
