package com.lcapp.propertyEditors;

import java.beans.PropertyEditorSupport;

import com.lcapp.dto.CreditCard;

public class CreditCardEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		String[] split = text.split("-");

		CreditCard creditCard = new CreditCard();
		creditCard.setFirstFourDigits(Integer.valueOf(split[0]));
		creditCard.setSecondFourDigits(Integer.valueOf(split[1]));
		creditCard.setThirdFourDigits(Integer.valueOf(split[2]));
		creditCard.setLastFourDigits(Integer.valueOf(split[3]));
		setValue(creditCard);

	}

	@Override
	public String getAsText() {

		CreditCard c = (CreditCard) getValue();
		return "Sample:" + c;
	}

}
