package com.lcapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcapp.dao.FlamesResultDao;
import com.lcapp.dto.FlamesAppHistory;
import com.lcapp.dto.UserInfoDto;
import com.lcapp.propertyEditors.UserAndCrushNameEditor;
import com.lcapp.service.FlamesAppServiceImp;

@Controller
public class LcAppController {
	@Autowired
	private FlamesAppServiceImp flamesAppServiceImp;
	@Autowired
	private FlamesResultDao flamesResultDao;

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
			FlamesAppHistory flamesAppHistory = new FlamesAppHistory();
			
		if (result.hasErrors()) {
			List<ObjectError> lerror = result.getAllErrors();
			lerror.forEach(System.out::println);
			return "home-page";
		}
		String appResult = flamesAppServiceImp.calculateResult(userInfo.getUserName().trim(), userInfo.getCrushName().trim());
		session.setAttribute("appResult", appResult);
		flamesAppHistory.setUserName(userInfo.getUserName());
		flamesAppHistory.setCrushName(userInfo.getCrushName());
		flamesAppHistory.setAppResult(appResult);
		flamesResultDao.insert(flamesAppHistory);
//	Cookie ck=new Cookie("appUserName",userInfo.getUserName());
//	ck.setMaxAge(60*60*24);
//	response.addCookie(ck);
		
		session.setAttribute("userName", userInfo.getUserName());
		session.setAttribute("crushName", userInfo.getCrushName());
		return "result-page";
	}
	
	@RequestMapping("/viewAppHistory")
	public String appHistory(Model model) {
		List<FlamesAppHistory> appHistory = flamesResultDao.getAppHistory();
		model.addAttribute("appHistory",appHistory);
		return "show-app-history";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		UserAndCrushNameEditor userAndCrushNameEditor = new UserAndCrushNameEditor();
		binder.registerCustomEditor(String.class, userAndCrushNameEditor);
		
	}
}
