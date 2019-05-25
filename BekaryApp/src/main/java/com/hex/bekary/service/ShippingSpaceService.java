package com.hex.bekary.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hex.bekary.beans.CartBean;
import com.hex.bekary.beans.ProductBean;
import com.hex.bekary.util.PackagesWithPrice;

public class ShippingSpaceService {

	public static Logger log = LogManager.getLogger();
	private static DecimalFormat priceFormat = new DecimalFormat("#.##");
	
	public Map<String, CartBean> prepareOrder(Map<String, List<Integer>> minimumPackagesAllocatedPerItem,
			Map<String, ProductBean> inputOrder) {
		
		log.info("Start: Preparing shippable order format");
		Map<String, CartBean> shippableBean = new LinkedHashMap<>();
		inputOrder.forEach((itemCode, product)-> {
			String itemDescription =  "";
			CartBean productView= new CartBean();
			Double totalCost = 0.0;
			List<String> priceBreakDownPerProduct = new ArrayList<>();
			Map<Integer,Integer> noOfPackagesPerPackage=countNoOfPackagesPerPackage(minimumPackagesAllocatedPerItem.get(itemCode));
		
			for(Integer pkg:noOfPackagesPerPackage.keySet())
			{
				String code= itemCode+"_"+pkg;
				Double packagePrice= PackagesWithPrice.valueOf(code).getPrice();
				Integer noOfPackages=noOfPackagesPerPackage.get(pkg);
				totalCost = totalCost + (noOfPackages * packagePrice);
				String priceBreakDownPerPackage= noOfPackages+" x "+ pkg+" $"+packagePrice;
				priceBreakDownPerProduct.add(priceBreakDownPerPackage);
			}
			
			String itemHeaderInCart = product.getQuantity()+" "+product.getItemCode()+" $"+priceFormat.format(totalCost);
					
			
			productView.setItemCode(product.getItemCode());
			productView.setItemName(product.getItemName());
			productView.setQuantity(product.getQuantity().toString());
			productView.setDescription(itemDescription);
			productView.setTotalCost(priceFormat.format(totalCost));
			productView.setPriceBreakDown(priceBreakDownPerProduct);
			productView.setItemHeaderInCart(itemHeaderInCart);
			
			shippableBean.put(itemCode, productView);
		});
		
		log.info("End: Preparing shippable order format");
		return shippableBean;
		
	}
	
	
	private Map<Integer,Integer> countNoOfPackagesPerPackage(List<Integer> list) {
		Map<Integer,Integer> noOfPackagesPerPackage= new LinkedHashMap<>();
		
		list.forEach(pkg-> {
			if(noOfPackagesPerPackage.containsKey(pkg)) {
				noOfPackagesPerPackage.put(pkg, noOfPackagesPerPackage.get(pkg)+1);
			}else {
				noOfPackagesPerPackage.put(pkg,1);
			}
		});
		return noOfPackagesPerPackage;
	}
	
}
