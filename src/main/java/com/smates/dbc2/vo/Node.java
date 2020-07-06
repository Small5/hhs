package com.smates.dbc2.vo;

import java.util.List;

/**
 * 树形图节点
 * 
 * @author baijw
 *
 */
public class Node {

	private String name;
	private List<Node> children;

	public Node() {
	}

	public Node(String name, List<Node> children) {
		this.name = name;
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(List<Node> children) {
		this.children = children;
	}

}
