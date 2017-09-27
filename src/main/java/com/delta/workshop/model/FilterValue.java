/**
 * 
 */
package com.delta.workshop.model;

//import java.util.List;

/**
 * @author Song.Li
 * 
 */
public class FilterValue {
	private Integer id;
	private Integer keyId;
	private Integer parentId;
	private String name;// case1
	private String description;// Case1
	// private List<DataQuality> dataQualityList;
	// public List<DataQuality> getDataQualityList() {
	// return dataQualityList;
	// }
	// public void setDataQualityList(List<DataQuality> dataQualityList) {
	// this.dataQualityList = dataQualityList;
	// }

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getKeyId() {
		return keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}
}
