package com.nordea.asmnt.util;

/**
 * Description - Text Conversion Application's Exception
 * @author Sriphani
 *
 */
public class ConversionException {

	private String message;

	public ConversionException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
