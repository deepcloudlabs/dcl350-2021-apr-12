package com.example.hr.dto;

public class RestErrorMessage {
	private String reason;
	private int errorCode;

	public RestErrorMessage() {
	}

	public RestErrorMessage(String reason, int errorCode) {
		this.reason = reason;
		this.errorCode = errorCode;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "RestErrorMessage [reason=" + reason + ", errorCode=" + errorCode + "]";
	}

}
