package com.springbootcrud.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionCustom extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Object entity;
	private Object errorMessage;
	private Object field;
	private Object value;

	public ExceptionCustom(String msg) {
		super(msg);
	}

	@Override
	public String toString() {
		return entity + " " + errorMessage + " " + field + " " + value + "\n";
	}

}
