package com.ooqn.core.exception;

/**
 * 自定义API异常
 */
public class JwtException extends RuntimeException {

	private int status;

	private String message;

	public JwtException(int errorCode, String message) {
		super();
		this.status = errorCode;
		this.message = message;
	}
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
