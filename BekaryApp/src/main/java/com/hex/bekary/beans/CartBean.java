package com.hex.bekary.beans;

public class CartBean {

	private String itemName;
	private String itemCode;
	private Integer quantity;
	private String description;
	private Double totalCost;
	
	public CartBean(String itemName, String itemCode, Integer quantity, String description, Double totalCost) {
		this.itemName = itemName;
		this.itemCode = itemCode;
		this.quantity = quantity;
		this.description = description;
		this.totalCost = totalCost;
	}
	
	
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
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}


	@Override
	public String toString() {
		return "CartBean [itemName=" + itemName + ", itemCode=" + itemCode + ", quantity=" + quantity + ", description="
				+ description + ", totalCost=" + totalCost + "]";
	}
	
	
	
}
