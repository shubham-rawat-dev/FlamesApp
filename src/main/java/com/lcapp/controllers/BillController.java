package com.lcapp.controllers;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcapp.dto.BillDto;
import com.lcapp.dto.CreditCard;
import com.lcapp.propertyEditors.CustomCurrencyEditor;

@Controller
public class BillController {

	@RequestMapping("/showBill")
	public String showBill(@ModelAttribute("billDto") BillDto billDto) {
		System.out.println("inside showBill controller");
		CreditCard creditCard = new CreditCard();
		creditCard.setFirstFourDigits(1111);
		creditCard.setSecondFourDigits(7777);
		creditCard.setThirdFourDigits(3333);
		creditCard.setLastFourDigits(55555);
		billDto.setCreditCard(creditCard);
		return "bill-page";

	}

	@RequestMapping("/processBill")
	public String processBill(@Valid @ModelAttribute("billDto") BillDto billDto, BindingResult result) {
		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();
			allErrors.forEach(System.out::println);
			return "bill-page";
		}
		return "bill-result-page";

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, "date", customDateEditor);
		NumberFormat numberFormat = new DecimalFormat("##,###.00");
		CustomNumberEditor customNumberEditor = new CustomNumberEditor(BigDecimal.class, numberFormat, true);
		binder.registerCustomEditor(BigDecimal.class, "amount", customNumberEditor);
		CustomCurrencyEditor customCurrencyEditor = new CustomCurrencyEditor();
		binder.registerCustomEditor(Currency.class, "currency", customCurrencyEditor);
		// CreditCardEditor creditCardEditor = new CreditCardEditor();
		// binder.registerCustomEditor(CreditCard.class,"creditCard",creditCardEditor);
	}

}
