package com.lcapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcapp.dto.UserInfoDto;
import com.lcapp.service.FlamesAppServiceImp;

@Controller
public class LcAppController {
	@Autowired
	private FlamesAppServiceImp flamesAppServiceImp;

	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfo") UserInfoDto userInfo, HttpServletRequest request) {

//	Cookie[] cookies = request.getCookies();
//	for(Cookie c:cookies)
//	{
//		if(c.getName().equals("appUserName")) {
//			String value = c.getValue();
//			userInfo.setUserName(value);
//		}
//	}

		return "home-page";
	}

	@GetMapping("/processHomepage")
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDto userInfo, BindingResult result,
			HttpSession session) {

		if (result.hasErrors()) {
			List<ObjectError> lerror = result.getAllErrors();
			lerror.forEach(System.out::println);
			return "home-page";
		}
		String appResult = flamesAppServiceImp.calculateResult(userInfo.getUserName(), userInfo.getCrushName());
		session.setAttribute("appResult", appResult);
//	Cookie ck=new Cookie("appUserName",userInfo.getUserName());
//	ck.setMaxAge(60*60*24);
//	response.addCookie(ck);

		session.setAttribute("userName", userInfo.getUserName());

		return "result-page";
	}

}
