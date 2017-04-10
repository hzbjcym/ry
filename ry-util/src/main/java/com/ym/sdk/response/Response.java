package com.ym.sdk.response;

import java.io.Serializable;

public class Response implements Serializable {
	private static final long serialVersionUID = 8266755755258144054L;
	private int httpStatus;
	private String responseBody;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

}