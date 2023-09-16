package com.lcapp.converters;

import org.springframework.core.convert.converter.Converter;

import com.lcapp.dto.CreditCard;

public class CreditCardConverterObjectToString implements Converter<CreditCard, String> {

	@Override
	public String convert(CreditCard source) {
		return "sample:" + source;
	}

}
