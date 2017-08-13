package com.fyd.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fyd.partner.dto.RegistrationNotificationDto;
import com.fyd.partner.service.ManagePartnerService;

@Controller
@RequestMapping(path="/confirm-registration-controller.htm")
public class ConfirmRegistrationController {

	@Autowired
	ManagePartnerService managePartnerService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String confirmRegistration(Model model,@RequestParam String userName,@RequestParam String activationCode){
		RegistrationNotificationDto notification=null;
		managePartnerService.activeAccount(userName, activationCode);
		notification=new RegistrationNotificationDto();
		notification.setEmailId(userName);
		model.addAttribute("notification", notification);
		return "partner-registration-success";
	}

	
}
