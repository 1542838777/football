package com.tongxue.footballguessing.exception;

public class DBException extends Exception{
	public DBException(String message) {
		super(message);
		this.errorMsg = errorMsg;
	}

	private  String errorMsg;

}
