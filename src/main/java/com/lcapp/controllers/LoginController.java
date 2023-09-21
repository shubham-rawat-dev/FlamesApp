package com.lcapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/loginPage")
	public String loginPage()
	{
	return "login-page";	
	}

}
