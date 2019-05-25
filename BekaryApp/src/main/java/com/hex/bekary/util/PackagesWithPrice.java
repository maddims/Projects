package com.hex.bekary.util;

public enum PackagesWithPrice {

	VS5_3(6.99),
	VS5_5(8.99),
	MB11_2(9.95),
	MB11_5(16.95),
	MB11_8(24.95),
	CF_3(5.95),
	CF_5(9.95),
	CF_9(16.99);
	
	private final double price;
	
	PackagesWithPrice(double price){
		this.price = price;
	}
	
	 public double getPrice() {
	        return price;
	 }
	
		
}
