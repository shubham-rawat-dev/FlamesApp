package com.lcapp.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.lcapp.dto.CreditCard;

public class CreditCardformatter implements Formatter<CreditCard> {

	@Override
	public String print(CreditCard object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CreditCard parse(String text, Locale locale) throws ParseException {
		String[] split = text.split("-");
		CreditCard creditCard = new CreditCard();
		creditCard.setFirstFourDigits(Integer.valueOf(split[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(split[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(split[2]));
		creditCard.setLastFourDigits(Integer.valueOf(split[3]));

		return creditCard;
	}

}
