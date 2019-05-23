package com.hex.bekary.util;

public enum Packages {
	
	PKG_2(2),
	PKG_3(3),
	PKG_5(5),
	PKG_8(8),
	PKG_9(9);
	
	private final Integer pkg;
	
	Packages(Integer pkg){
		this.pkg = pkg;
	}
	
	 public Integer getPackage() {
	        return pkg;
	 }
}
