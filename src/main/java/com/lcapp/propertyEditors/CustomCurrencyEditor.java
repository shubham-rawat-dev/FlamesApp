package com.lcapp.propertyEditors;

import java.beans.PropertyEditorSupport;
import java.util.Currency;

public class CustomCurrencyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Currency c = Currency.getInstance(text.toUpperCase());
		setValue(c);
	}

}
