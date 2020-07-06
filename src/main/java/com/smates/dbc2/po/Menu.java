package com.smates.dbc2.po;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String menuId;
	private String menuName;
	private String parentId;
	private String menuUrl;
	private Integer order;
	private String permition;
	private String englishName;
	private List<Menu> submenus;

	public Menu() {
	}

	public Menu(String menuId, String menuName, String parentId, String menuUrl, Integer order, String permition,
			String englishName, List<Menu> submenus) {
		this.menuId = menuId;
		this.menuName = menuName;
		this.parentId = parentId;
		this.menuUrl = menuUrl;
		this.order = order;
		this.permition = permition;
		this.englishName = englishName;
		this.submenus = submenus;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<Menu> getSubmenus() {
		return submenus;
	}

	public void setSubmenus(List<Menu> submenus) {
		this.submenus = submenus;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public String getPermition() {
		return permition;
	}

	public void setPermition(String permition) {
		this.permition = permition;
	}

	@Override
	public String toString() {
		return "Menu [menuId=" + menuId + ", menuName=" + menuName + ", parentId=" + parentId + ", menuUrl=" + menuUrl
				+ ", order=" + order + ", submenus=" + submenus + "]";
	}

}