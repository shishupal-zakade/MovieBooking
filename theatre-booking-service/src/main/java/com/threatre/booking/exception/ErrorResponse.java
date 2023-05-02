// Custom Error Response Class
package com.threatre.booking.exception;

public class ErrorResponse {

	private int statusCode;
	private String message;

	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	public ErrorResponse(int value, String message2) {
		statusCode = value;
		message = message2;
	}

	/**
	 * @return the statusCode
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [statusCode=" + statusCode + ", message=" + message + "]";
	}
	
	
}
