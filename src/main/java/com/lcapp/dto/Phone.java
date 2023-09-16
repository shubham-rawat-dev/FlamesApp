package com.lcapp.dto;

public class Phone {
	@Override
	public String toString() {
		return countryCode + "-" + userNumber;
	}

	private String countryCode;
	private String userNumber;

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

}
