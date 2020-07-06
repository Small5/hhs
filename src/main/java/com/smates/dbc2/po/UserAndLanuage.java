package com.smates.dbc2.po;

/**
 * 用户默认语言po
 * 
 * @author baijw
 *
 */
public class UserAndLanuage {

	private String accountNumber;
	private String language;
	private String guide;

	public UserAndLanuage() {
	}

	public UserAndLanuage(String accountNumber, String language, String guide) {
		this.accountNumber = accountNumber;
		this.language = language;
		this.guide = guide;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGuide() {
		return guide;
	}

	public void setGuide(String guide) {
		this.guide = guide;
	}

}