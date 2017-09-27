package com.delta.workshop.common.response;

import java.io.Serializable;

public class CommonResultResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;
	private String message;
	private Object result;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public CommonResultResponse() {
	}

	/**
	 * 构造函数
	 * 
	 * @param code
	 * @param message
	 * @param result
	 */
	public CommonResultResponse(int code, String message, Object result) {
		this.code = code;
		this.message = message;
		if (result != null)
			this.result = result;
	}

	/**
	 * 构造函数
	 * 
	 * @param code
	 * @param message
	 */
	public CommonResultResponse(int code, String message) {
		this(code, message, null);
	}

}
