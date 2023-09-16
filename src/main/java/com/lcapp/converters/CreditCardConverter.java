package com.lcapp.converters;

import org.springframework.core.convert.converter.Converter;

import com.lcapp.dto.CreditCard;

public class CreditCardConverter implements Converter<String, CreditCard> {

	@Override
	public CreditCard convert(String source) {
		String[] split = source.split("-");
		CreditCard creditCard = new CreditCard();
		creditCard.setFirstFourDigits(Integer.valueOf(split[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(split[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(split[2]));
		creditCard.setLastFourDigits(Integer.valueOf(split[3]));

		return creditCard;

	}

}
