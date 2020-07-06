package com.smates.dbc2.vo;

import java.util.ArrayList;
import java.util.List;

public class DoubleArray {
	protected List<Double> item;

	public DoubleArray() {
	}

	public DoubleArray(List<Double> item) {
		setItem(item);
	}

	public void setItem(List<Double> item) {
		this.item = item;
	}

	public List<Double> getItem() {
		if (item == null) {
			item = new ArrayList<Double>();
		}
		return this.item;
	}

}
