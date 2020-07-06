package com.smates.dbc2.po;

/**
 * 中英文对照
 * 
 * @author baijw
 *
 */
public class ChineseAndEnglish {

	private int index;
	private String chinese;
	private String english;

	public ChineseAndEnglish() {
		super();
	}

	public ChineseAndEnglish(int index, String chinese, String english) {
		super();
		this.index = index;
		this.chinese = chinese;
		this.english = english;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getChinese() {
		return chinese;
	}

	public void setChinese(String chinese) {
		this.chinese = chinese;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

}
