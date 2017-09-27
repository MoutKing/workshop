package com.delta.workshop.util;

/**
 * @author Qiang.Wei
 * @date 创建时间：2017-9-4 上午11:35:00
 * @Description
 */
public class Validation {
	/**
	 * 校验字符串为中文（包括繁简），并且长度为45
	 * 
	 * @param sgr
	 * @return
	 */
	public static boolean validateString(String str) {
		boolean flag = false;
		if (null != str && str.replace(" ", "").matches("^[A-Za-z\\u4e00-\\u9fa5]{1,45}$")) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 校验int是否为正整数
	 * 
	 * @param num
	 * @return
	 */
	public static boolean validateInteger(Integer num) {
		boolean flag = false;
		if (null != num && num > 0 && num.toString().matches("^[0-9]{1,11}$")) {
			flag = true;
		}
		return flag;
	}

	public static boolean validateVote(Integer num) {
		boolean flag = false;
		if (null != num && 0 < num && num <11) {
			flag = true;
		}
		return flag;
	}
}
