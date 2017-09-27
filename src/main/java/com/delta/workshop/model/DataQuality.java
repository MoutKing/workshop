/**
 * 
 */
package com.delta.workshop.model;

/**
 * @author Song.Li
 *
 */
public class DataQuality {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private Integer total;
	private Integer zeros;
	private Integer erratics;
	private Integer outliers;
	private Integer missings;
	private Integer consistency;
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getZeros() {
		return zeros;
	}
	public void setZeros(Integer zeros) {
		this.zeros = zeros;
	}
	public Integer getErratics() {
		return erratics;
	}
	public void setErratics(Integer erratics) {
		this.erratics = erratics;
	}
	public Integer getOutliers() {
		return outliers;
	}
	public void setOutliers(Integer outliers) {
		this.outliers = outliers;
	}
	public Integer getMissings() {
		return missings;
	}
	public void setMissings(Integer missings) {
		this.missings = missings;
	}
	public Integer getConsistency() {
		return consistency;
	}
	public void setConsistency(Integer consistency) {
		this.consistency = consistency;
	}
	
}
