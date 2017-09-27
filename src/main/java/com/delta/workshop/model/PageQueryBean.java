package com.delta.workshop.model;

public class PageQueryBean<T> {
	private T data;
	private Integer PageNo;
	private Integer pageSize;
	private Integer totalnum;
	private Integer startIndex;
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getPageNo() {
		return PageNo;
	}
	public void setPageNo(Integer pageNo) {
		PageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(Integer totalnum) {
		this.totalnum = totalnum;
	}
	public Integer getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}
	
}
