package com.delta.workshop.common.response;

public class ResponseCode {
	/**
	 * 请求成功状态码
	 */
	public static final int SUCCESS = 200000;

	/**
	 * 请求参数异常状态码
	 */
	public static final int PARAMS_ERROR = 400001;

	/**
	 * server运行异常状态码
	 */
	public static final int SERVER_ERROR = 500000;

	/**
	 * server拒绝服务状态码
	 */
	public static final int FORBIDDEN = 400003;
}
