package com.fyd.registration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationAjaxController {

	@RequestMapping(value = "/partner-email-exist.htm", method = RequestMethod.GET)
	@ResponseBody
	public String isBrandNameExists(@RequestParam String emailId){
		if(emailId.equals("sidharthaswain100@gmail.com")){
	    return "email id already exist";
		}
		
	   return null;
	}
}
