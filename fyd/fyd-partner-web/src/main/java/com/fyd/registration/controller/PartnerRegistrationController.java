package com.fyd.registration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fyd.form.PartnerRegistrationForm;
import com.fyd.partner.dto.AddressDto;
import com.fyd.partner.dto.PartnerRegistrationDto;
import com.fyd.partner.dto.RegistrationNotificationDto;
import com.fyd.partner.service.ManagePartnerService;
import com.fyd.partner.service.ManagePartnerServiceImpl;
import com.fyd.validator.PartnerRegistrationValidator;

/*
 * 
 *@author sidhartha
* @version 1.0
* @since 2017-05-09 
 */

@Controller
@RequestMapping(path = "/partner-registration.htm")
public class PartnerRegistrationController {

	@Autowired
	ManagePartnerService managePartnerService;
	@Autowired
	PartnerRegistrationValidator registrationValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String showRegistration(Model model) {
		PartnerRegistrationForm partnerRegistrationForm = null;
		partnerRegistrationForm = new PartnerRegistrationForm();
		model.addAttribute("partnerRegistrationForm", partnerRegistrationForm);
		return "partner-registration";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String register(Model model, PartnerRegistrationForm registrationForm, BindingResult errors) {
		// validation check

		if (registrationValidator.supports(registrationForm.getClass())) {
			registrationValidator.validate(registrationForm, errors);
			if (errors.hasErrors()) {
				return "partner-registration";
			}
		}

		PartnerRegistrationDto partnerRegistrationDto = null;
		AddressDto primeryAddressDto = null;
		AddressDto secondaryAddressDto = null;
		RegistrationNotificationDto notification = null;

		partnerRegistrationDto = new PartnerRegistrationDto();
		partnerRegistrationDto.setRegisteredName(registrationForm.getRegisteredName());
		partnerRegistrationDto.setRegistrationNo(registrationForm.getRegistrationNo());
		partnerRegistrationDto.setEstYear(registrationForm.getEstYear());
		partnerRegistrationDto.setDescription(registrationForm.getDescription());
		partnerRegistrationDto.setPrimeryMobileNo(registrationForm.getPrimeryMobileNo());
		partnerRegistrationDto.setSecondaryMobileNo(registrationForm.getSecondaryMobileNo());
		partnerRegistrationDto.setPrimeryEmailid(registrationForm.getPrimeryEmailid());
		partnerRegistrationDto.setSecondaryEmailid(registrationForm.getSecondaryEmailid());

		primeryAddressDto = new AddressDto();
		primeryAddressDto.setAddressLine1(registrationForm.getPrimeryAddressLine1());
		primeryAddressDto.setAddressLine2(registrationForm.getPrimeryAddressLine2());
		primeryAddressDto.setCity(registrationForm.getPrimeryCity());
		primeryAddressDto.setState(registrationForm.getPrimeryState());
		primeryAddressDto.setZip(registrationForm.getPrimeryZip());
		primeryAddressDto.setCountry(registrationForm.getPrimeryCountry());
		partnerRegistrationDto.setPrimeryAddress(primeryAddressDto);

		if (registrationForm.getSecondaryAddressLine1() != null 
				&& registrationForm.getSecondaryCity() != null 
				&& registrationForm.getSecondaryState() != null
				&& registrationForm.getSecondaryZip() != 0
				&& registrationForm.getSecondaryCountry() != null
				&& ("".equals(registrationForm.getSecondaryAddressLine1().trim()))==false
				&& ("".equals(registrationForm.getSecondaryCity().trim()))==false
				&& ("".equals(registrationForm.getSecondaryState().trim()))==false
				&& ("".equals(String.valueOf(registrationForm.getSecondaryZip()).toString().trim()))==false
				&& ("".equals(registrationForm.getSecondaryCountry().trim())==false)) {

			secondaryAddressDto = new AddressDto();
			secondaryAddressDto.setAddressLine1(registrationForm.getSecondaryAddressLine1());
			secondaryAddressDto.setAddressLine2(registrationForm.getSecondaryAddressLine2());
			secondaryAddressDto.setCity(registrationForm.getSecondaryCity());
			secondaryAddressDto.setState(registrationForm.getSecondaryState());
			secondaryAddressDto.setZip(registrationForm.getSecondaryZip());
			secondaryAddressDto.setCountry(registrationForm.getSecondaryCountry());
			partnerRegistrationDto.setSecondaryAddress(secondaryAddressDto);
		}

		managePartnerService.registerBasicInfo(partnerRegistrationDto);

		notification = new RegistrationNotificationDto();
		notification.setPartnerRegisteredName(registrationForm.getRegisteredName());
		notification.setEmailId(registrationForm.getPrimeryEmailid());
		model.addAttribute("notification", notification);

		return "primery-registration-success";
	}

	public PartnerRegistrationValidator getRegistrationValidator() {
		return registrationValidator;
	}

	public void setRegistrationValidator(PartnerRegistrationValidator registrationValidator) {
		this.registrationValidator = registrationValidator;
	}

	public void setManagePartnerService(ManagePartnerServiceImpl managePartnerService) {
		this.managePartnerService = managePartnerService;
	}

}
