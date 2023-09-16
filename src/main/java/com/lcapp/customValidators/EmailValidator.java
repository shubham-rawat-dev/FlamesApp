package com.lcapp.customValidators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lcapp.dto.UserRegistrationDto;

public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDto.email", "email.empty");
		String email = ((UserRegistrationDto) target).getCommunicationDto().getEmail();
		if (!email.endsWith("gmail.com"))
			errors.rejectValue("communicationDto.email", "email.invalidDomain");
	}

}
