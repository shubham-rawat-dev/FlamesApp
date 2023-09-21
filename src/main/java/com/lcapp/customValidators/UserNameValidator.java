package com.lcapp.customValidators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lcapp.dto.UserRegistrationDto;

public class UserNameValidator implements Validator {
//to check if UserNameValidator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDto.class.equals(clazz);
	}

//write our custom validation logic here
	@Override
	public void validate(Object target, Errors errors) {
		// check if field is null
		ValidationUtils.rejectIfEmpty(errors, "username", "userName.empty", "*User Name cannot be empty");
		// string should contain a _
		String userName = ((UserRegistrationDto) target).getUsername();
		if (!userName.contains("_"))
			errors.rejectValue("username", "userName.errorCode", "*String must contain an underscore(_)");
	}

}
