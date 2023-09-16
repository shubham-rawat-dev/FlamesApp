package com.lcapp.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class LcAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class<?>[] arr = { MyConfig.class };
		return arr;
	}

	@Override
	protected String[] getServletMappings() {
		String[] arr = { "/" };
		return arr;
	}

}
