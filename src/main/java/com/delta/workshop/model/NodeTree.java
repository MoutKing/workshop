package com.delta.workshop.model;

import java.util.List;

public class NodeTree {
	private Integer nodeId;
	private Integer treeId;
	private Boolean leaf;
	private String featureParameter;
	private Float threshold;
	private Float samples;
	private String groups;
	private Integer parentNodeId;
	private String direction;
	private String description;
	private List<NodeTree> childerNodeTree;

	public Integer getNodeId() {
		return nodeId;
	}

	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}

	public Integer getTreeId() {
		return treeId;
	}

	public void setTreeId(Integer treeId) {
		this.treeId = treeId;
	}

	public Boolean getLeaf() {
		return leaf;
	}

	public void setLeaf(Boolean leaf) {
		this.leaf = leaf;
	}

	public String getFeatureParameter() {
		return featureParameter;
	}

	public void setFeatureParameter(String featureParameter) {
		this.featureParameter = featureParameter == null ? null : featureParameter.trim();
	}

	public Float getThreshold() {
		return threshold;
	}

	public void setThreshold(Float threshold) {
		this.threshold = threshold;
	}

	public Float getSamples() {
		return samples;
	}

	public void setSamples(Float samples) {
		this.samples = samples;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups == null ? null : groups.trim();
	}

	public Integer parentNodeId() {
		return parentNodeId;
	}

	public void setParentNodeId(Integer parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction == null ? null : direction.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public List<NodeTree> getChilderNodeTree() {
		return childerNodeTree;
	}

	public void setChilderNodeTree(List<NodeTree> childerNodeTree) {
		this.childerNodeTree = childerNodeTree;
	}
}
