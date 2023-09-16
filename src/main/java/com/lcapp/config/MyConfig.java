package com.lcapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.lcapp.converters.CreditCardConverter;
import com.lcapp.converters.CreditCardConverterObjectToString;
import com.lcapp.formatters.PhoneNumberFormatter;

@Configuration
@ComponentScan(basePackages = "com.lcapp")
@EnableWebMvc
public class MyConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
//registering our formatter with spring
		System.out.println("inside phone add formatter");
		registry.addFormatter(new PhoneNumberFormatter());
		// registry.addFormatter(new CreditCardformatter());
		registry.addConverter(new CreditCardConverter());
		registry.addConverter(new CreditCardConverterObjectToString());
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setPrefix("/WEB-INF/views/");
		irvr.setSuffix(".jsp");
		return irvr;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
		resourceBundleMessageSource.setBasename("message");
		return resourceBundleMessageSource;
	}

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource());
		return localValidatorFactoryBean;
	}

	@Override
	public Validator getValidator() {
		return validator();
	}

}