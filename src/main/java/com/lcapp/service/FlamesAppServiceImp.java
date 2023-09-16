package com.lcapp.service;

import org.springframework.stereotype.Service;

@Service
public class FlamesAppServiceImp implements FlamesAppService {
	public final String FLAMES_APP_FORMULA = "FLAMES";

	@Override

	public String calculateResult(String userName, String crushName) {

		int userNameAndCrushNameCount = (userName + crushName).length();
		int formulaCount = FLAMES_APP_FORMULA.length();
		System.out.println("Flames len=" + formulaCount);
		int remainder = userNameAndCrushNameCount % formulaCount;
		char result = FLAMES_APP_FORMULA.charAt(remainder);
		String finalResult = whatsBetweenUs(result);
		return finalResult;
	}

	@Override
	public String whatsBetweenUs(char ch) {
		String result = "";

		if (ch == 'F') {
			return result = FlamesAppConstants.F_CHAR_MEANING;
		} else if (ch == 'L') {
			return result = FlamesAppConstants.L_CHAR_MEANING;
		} else if (ch == 'A') {
			return result = FlamesAppConstants.A_CHAR_MEANING;
		} else if (ch == 'M') {
			return result = FlamesAppConstants.M_CHAR_MEANING;
		} else if (ch == 'E') {
			return result = FlamesAppConstants.E_CHAR_MEANING;
		} else if (ch == 'S') {
			return result = FlamesAppConstants.S_CHAR_MEANING;
		}
		return result;

	}
}