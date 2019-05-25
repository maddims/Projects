package com.hex.bekary.exceptions;

public class BekaryAppException extends RuntimeException{

	private static final long serialVersionUID = 6015721776061577354L;
	String message;
	
	public BekaryAppException(String message){
		super();
		this.message=message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
