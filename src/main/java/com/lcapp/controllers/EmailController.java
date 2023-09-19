package com.lcapp.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcapp.dto.EmailDto;
import com.lcapp.service.EmailService;

@Controller
public class EmailController {
	@Autowired
	private EmailService emailService;

	@RequestMapping("/sendEmail")
	public String sendEmail(@ModelAttribute EmailDto emailDto) {
		return "send-email-page";

	}

	@RequestMapping("/processEmail")
	public String processEmail(@ModelAttribute("emailDto") EmailDto emailDto, HttpSession session, Model model) {
		String result = (String) session.getAttribute("appResult");
		String userName = (String) session.getAttribute("userName");
		String crushName = (String) session.getAttribute("crushName");
		
		String newUserName = "Mr " + userName;
		
		model.addAttribute("userName", newUserName);
	

		String message = "<div style='border:2px solid #e2e2e2;padding:20px;'>" + "<h1>" + "Result of Flames app:\n "
				+ "<b>" +userName+" and "+crushName+" are\n"+ result + "</b>" + "</n>" + "</h1>" + "</div>";
		String userEmail = emailDto.getUserEmail();
		boolean flag = emailService.sendEmail("Flames App", message, userEmail);
		if (flag)
			System.out.println("sent");
		else
			System.out.println("failed");
		

		return "process-email-page";

	}
}
