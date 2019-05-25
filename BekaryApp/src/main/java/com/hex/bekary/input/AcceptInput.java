package com.hex.bekary.input;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.hex.bekary.beans.ProductBean;
import com.hex.bekary.exceptions.BekaryAppException;
import com.hex.bekary.service.BekaryServiceImpl;

public class AcceptInput {
	
	public static Logger log = LogManager.getLogger();
	
	public static Map<String,ProductBean> takeInputOrder(){
		
		log.info("Please enter your order[Quantity Item]");
		Map<String,ProductBean> order = new LinkedHashMap<>();
		try(Scanner inputOrder = new Scanner(System.in);) {
		String inputLine;
		String[] packgeAndPrice; 	
		
		while(inputOrder.hasNextLine()) {
			ProductBean product= new ProductBean();
			inputLine = inputOrder.nextLine();			
			if(inputLine.isEmpty()) {
				break;
			}
			packgeAndPrice = inputLine.split(" ");
			String quantity = packgeAndPrice[0];
			String itemCode= packgeAndPrice[1];
			boolean isInputValid = validateInput(itemCode,quantity);
			if(isInputValid) {
			product.setItemCode(itemCode);
			product.setQuantity(Integer.parseInt(quantity));
			product.setItemName(formItemName(itemCode));			
			order.put(itemCode, product);
			}
			else {
				log.info("Please choose valid Products");
			}
		 }
		}
		catch (BekaryAppException bae) {
			throw new  BekaryAppException(bae.getLocalizedMessage());
		}
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
	
	public static boolean validateInput(String itemCode, String quantity) {
				 
		Map<String,Integer[]> availablePackages= new BekaryServiceImpl().getAvailablePackagesPerItem();
		
		if(availablePackages.isEmpty()) {
			throw new BekaryAppException("No products are available");
		}
		
		if(!availablePackages.containsKey(itemCode)) {
			throw new BekaryAppException("Entered Product doesn't exist");
		}
		
		if(itemCode.isEmpty() || itemCode==" ")
		{
			throw new BekaryAppException("Product code shouldn't be Empty");
		}
		
		try 
		{
			Integer.parseInt(quantity);
		}
		catch(NumberFormatException nfe) {
			throw new BekaryAppException("Quantity should be a valid number");
		}		
		return true;
	}

}
