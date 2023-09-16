package com.lcapp.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDto {
	@NotBlank(message = "{user.notBlank}")
	@Size(min = 3, max = 15, message = "{userName.size}")
	private String userName;
	@NotBlank(message = "*crushname cannot be blank")
	@Size(min = 3, max = 15, message = "*should be between 3-15")
	private String crushName;
	@AssertTrue(message = "*Please check to use our app")
	private boolean checkTermsAndConditions;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isCheckTermsAndConditions() {
		return checkTermsAndConditions;
	}

	public void setCheckTermsAndConditions(boolean checkTermsAndConditions) {
		this.checkTermsAndConditions = checkTermsAndConditions;
	}
}
