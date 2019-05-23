package com.hex.bekary.input;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hex.bekary.beans.CartBean;

public class AcceptInput {
	
	public static Logger log = LogManager.getLogger();
	
	public static Map<String,CartBean> takeInputOrder(){
		
		log.info("Please enter your order[Quantity Item]");
		Scanner inputOrder = new Scanner(System.in);
		String inputLine;
		String[] packgeAndPrice; 
		Map<String,CartBean> order = new LinkedHashMap<>();
		
		
		while(inputOrder.hasNextLine()) {
			CartBean orderDesc= new CartBean();
			inputLine = inputOrder.nextLine();			
			if(inputLine.isEmpty()) {
				break;
			}
			packgeAndPrice = inputLine.split(" ");
			String itemCode= packgeAndPrice[1];
			
			orderDesc.setItemCode(itemCode);
			orderDesc.setQuantity(Integer.parseInt(packgeAndPrice[0]));
			orderDesc.setItemName(formItemName(itemCode));
			
			order.put(itemCode, orderDesc);	
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
