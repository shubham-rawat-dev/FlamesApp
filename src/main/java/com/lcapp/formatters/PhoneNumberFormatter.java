package com.lcapp.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lcapp.dto.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone object, Locale locale) {
		System.out.println("inside print method");
		return object.toString();
	}

	@Override
	public Phone parse(String text, Locale locale) throws ParseException {
		System.out.println("inside parse method of fomatter");
		// parser is to convert String object to custom object type
		Phone phone = new Phone();
		String[] split = text.split("-");

		if (text.indexOf('-') == -1) {

			phone.setCountryCode("91");
			phone.setUserNumber(split[0]);

		} else if (text.indexOf('-') == 0) {
			phone.setCountryCode("91");
			phone.setUserNumber(split[1]);
		} else {
			phone.setCountryCode(split[0]);
			phone.setUserNumber(split[1]);
		}
		return phone;
	}

}
