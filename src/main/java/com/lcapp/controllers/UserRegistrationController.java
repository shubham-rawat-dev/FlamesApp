package com.lcapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcapp.customValidators.EmailValidator;
import com.lcapp.customValidators.UserNameValidator;
import com.lcapp.dto.CommunicationDto;
import com.lcapp.dto.Phone;
import com.lcapp.dto.UserRegistrationDto;
import com.lcapp.propertyEditors.NamePropertyEditor;

@Controller
public class UserRegistrationController {

	@RequestMapping("/register")
	public String showUserRegPage(@ModelAttribute("userReg") UserRegistrationDto userRegistrationDto) {
		Phone phone = new Phone();
		phone.setCountryCode("91");
		phone.setUserNumber("789686787");
		CommunicationDto communicationDto = new CommunicationDto();
		communicationDto.setPhone(phone);
		userRegistrationDto.setCommunicationDto(communicationDto);
		return "user-registration-page";
	}

	@RequestMapping("/registrationSuccess")
	public String showRegSuccess(@Valid @ModelAttribute("userReg") UserRegistrationDto userRegistrationDto,
			BindingResult result) {

		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			allErrors.forEach(System.out::println);
			return "user-registration-page";
		}
		return "user-registration-success";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", editor);

		binder.addValidators(new UserNameValidator());
		NamePropertyEditor namePropertyEditor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", namePropertyEditor);

		binder.addValidators(new EmailValidator());
	}

}
