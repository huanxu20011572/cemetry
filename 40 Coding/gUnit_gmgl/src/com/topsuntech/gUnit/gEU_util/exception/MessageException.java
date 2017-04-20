package com.topsuntech.gUnit.gEU_util.exception;

public class MessageException extends Exception {

	public MessageException() {
		super();
	}

	public MessageException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageException(String message) {
		super(message);
	}

	public MessageException(Throwable cause) {
		super(cause);
	}

	public String getMessageKey() {
		return this.getMessage();
	}

	private Object[] paramters;

	public MessageException(String key, Object[] paramters) {
		super(key);
		this.paramters = paramters;
	}

	public Object[] getParamters() {
		return paramters;
	}
}
