package com.lcapp.dto;

import javax.validation.constraints.NotEmpty;

import com.lcapp.validator.Age;

public class UserRegistrationDto {
	@NotEmpty(message = "{string.notEmpty}")
	private String name;
	private String userName;
	private char[] password;
	private String countryName;
	private String[] hobbies;
	private String gender;
	@Age(lower = 23, upper = 45)
	private Integer age;

	private CommunicationDto communicationDto;

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public CommunicationDto getCommunicationDto() {
		return communicationDto;
	}

	public void setCommunicationDto(CommunicationDto communicationDto) {
		this.communicationDto = communicationDto;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

}
