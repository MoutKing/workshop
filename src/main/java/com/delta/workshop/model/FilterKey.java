/**
 * 
 */
package com.delta.workshop.model;

import java.util.List;

/**
 * @author Song.Li
 *
 */
public class FilterKey {
	private Integer id;
	private Integer workshopId;
	private Integer parentId;//dafault=0
	private String name;//case
	private String description;//Case
	private List<FilterValue> filterValueList;
	
	public List<FilterValue> getFilterValueList() {
		return filterValueList;
	}
	public void setFilterValueList(List<FilterValue> filterValueList) {
		this.filterValueList = filterValueList;
	}
	public Integer getWorkshopId() {
		return workshopId;
	}
	public void setWorkshopId(Integer workshopId) {
		this.workshopId = workshopId;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
//	public List<FilterValue> getFilterValueList() {
//		return filterValueList;
//	}
//	public void setFilterValueList(List<FilterValue> filterValueList) {
//		this.filterValueList = filterValueList;
//	}
//	public Integer getFilterKeyId() {
//		return filterKeyId;
//	}
//	public void setFilterKeyId(Integer filterKeyId) {
//		this.filterKeyId = filterKeyId;
//	}
}
