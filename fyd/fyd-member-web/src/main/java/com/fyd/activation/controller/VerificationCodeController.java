package com.fyd.activation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fyd.member.service.ManageMemberService;

@Controller
@RequestMapping("/member-account-activation.htm")
public class VerificationCodeController {
	@Autowired
	private ManageMemberService memberService;

	@RequestMapping(method = RequestMethod.GET)
	public String showValidationForm(Model model, @RequestParam("userId") String userId) {
		model.addAttribute("userId", userId);
		return "verificationform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String validate(HttpServletRequest request, @RequestParam("userId") String userId) {
		String verificationCode = request.getParameter("verificationcode");
		String dbVerificationCode = memberService.getUserInfo(Integer.parseInt(userId));
		if (verificationCode.equals(dbVerificationCode)) {
			memberService.updateUserStatus(Integer.parseInt(userId));
			return "verificationsuccess";
		}
		return "verificationfailure";
	}
}
