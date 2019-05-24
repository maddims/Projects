package com.hex.bekary.beans;

import java.util.List;

public class CartBean {

	private String itemName;
	private String itemCode;
	private String quantity;
	private String description;
	private String totalCost;
	private List<String> priceBreakDown;
	private String itemHeaderInCart;
	
	public CartBean() {
	}


	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}	
	public List<String> getPriceBreakDown() {
		return priceBreakDown;
	}
	public void setPriceBreakDown(List<String> priceBreakDown) {
		this.priceBreakDown = priceBreakDown;
	}


	public String getItemHeaderInCart() {
		return itemHeaderInCart;
	}


	public void setItemHeaderInCart(String itemHeaderInCart) {
		this.itemHeaderInCart = itemHeaderInCart;
	}


	@Override
	public String toString() {
		return "CartBean [itemName=" + itemName + ", itemCode=" + itemCode + ", quantity=" + quantity + ", description="
				+ description + ", totalCost=" + totalCost + ", priceBreakDown=" + priceBreakDown
				+ ", itemHeaderInCart=" + itemHeaderInCart + "]";
	}
	
	
	

}
