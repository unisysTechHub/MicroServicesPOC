package com.poc.banking.UserService.response;

public class BaseResponse {
	String responseCode;
	String message;
	public BaseResponse() {}
	public BaseResponse(String message, String responseCode) {
		this.message = message;
		this.responseCode = responseCode;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
