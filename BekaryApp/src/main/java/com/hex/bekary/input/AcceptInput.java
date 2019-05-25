package com.hex.bekary.input;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hex.bekary.beans.ProductBean;

public class AcceptInput {
	
	public static Logger log = LogManager.getLogger();
	
	public static Map<String,ProductBean> takeInputOrder(){
		
		log.info("Please enter your order[Quantity Item]");
		Scanner inputOrder = new Scanner(System.in);
		String inputLine;
		String[] packgeAndPrice; 
		Map<String,ProductBean> order = new LinkedHashMap<>();
		
		
		while(inputOrder.hasNextLine()) {
			ProductBean product= new ProductBean();
			inputLine = inputOrder.nextLine();			
			if(inputLine.isEmpty()) {
				break;
			}
			packgeAndPrice = inputLine.split(" ");
			String itemCode= packgeAndPrice[1];
			
			product.setItemCode(itemCode);
			product.setQuantity(Integer.parseInt(packgeAndPrice[0]));
			product.setItemName(formItemName(itemCode));
			
			order.put(itemCode, product);	
			}
		
		inputOrder.close();
		return order;
	}
	
	public static String formItemName(String itemCode) {
		
		String itemName="";
		switch(itemCode)
		{
		case "VS5":	itemName="Vegemite Scroll";
					break;
		case "MB11": itemName="Blueberry Muffin";
					break;
		case "CF": itemName="Croissant";
					break;
		}
		return itemName;
	}

}
