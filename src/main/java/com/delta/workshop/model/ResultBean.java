package com.delta.workshop.model;

public class ResultBean<T> {

	private T data;
	private Integer totalnum;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}
}
