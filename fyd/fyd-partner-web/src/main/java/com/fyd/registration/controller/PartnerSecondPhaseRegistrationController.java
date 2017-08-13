
package com.fyd.registration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fyd.form.PartnerOnlineUserForm;
import com.fyd.partner.bo.PartnerUserDetailsBo;
import com.fyd.partner.bo.TermsAndConditionBo;
import com.fyd.partner.dto.RegistrationNotificationDto;
import com.fyd.partner.dto.TermsAndConditionDto;
import com.fyd.partner.service.ManagePartnerService;
import com.fyd.validator.PartnerOnlineUserValidator;

/**
 *access the url 
 *contextPath/second-phase-partner-registration.htm?partnerId=partnerId&emailId=emailId
 * @author sidhartha
 *
 */

@Controller
@RequestMapping(path="/second-phase-partner-registration.htm")
public class PartnerSecondPhaseRegistrationController {


	@Autowired
	private ManagePartnerService managePartnerService;
	@Autowired
	private PartnerOnlineUserValidator partnerOnlineUserValidator;
	
		@RequestMapping(method=RequestMethod.GET)
		public String showRegistration(Model model,@RequestParam int partnerId,@RequestParam String emailId){
			
			PartnerOnlineUserForm partnerOnlineUserForm=null;
			partnerOnlineUserForm=new PartnerOnlineUserForm();
			partnerOnlineUserForm.setPartnerId(partnerId);
			partnerOnlineUserForm.setUserName(emailId);
			model.addAttribute("partnerOnlineUserForm", partnerOnlineUserForm);

			return "second-phase-partner-registration";
			
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public String register(Model model,@ModelAttribute("partnerOnlineUserForm")PartnerOnlineUserForm userForm,BindingResult errors){
			//validation check
			if(partnerOnlineUserValidator.supports(userForm.getClass())){
				partnerOnlineUserValidator.validate(userForm, errors);
				if(errors.hasErrors()){
					return "second-phase-partner-registration";
				}
			}
			
			
			PartnerUserDetailsBo partnerUserDetailsBo=null;
			RegistrationNotificationDto notification=null;
			
			partnerUserDetailsBo=new PartnerUserDetailsBo();
			partnerUserDetailsBo.setUserName(userForm.getUserName());
			partnerUserDetailsBo.setPassWord(userForm.getPassWord());
			partnerUserDetailsBo.setTermsAndConditionId(userForm.getTermsAndConditionId());
			partnerUserDetailsBo.setPartnerNo(userForm.getPartnerId());
			
			
			managePartnerService.registerUserDetails(partnerUserDetailsBo);
			
			
			notification=new RegistrationNotificationDto();
			notification.setEmailId(userForm.getUserName());
			model.addAttribute("notification", notification);
		
			return "second-phase-partner-registration-success";
		}

        @ModelAttribute("termsAndConditions")
		public List<TermsAndConditionDto> getTermsAndConditions(){
        	List<TermsAndConditionDto> termsAndConditionDtos=null;
			List<TermsAndConditionBo> termsAndConditionBos=null;
		
        	
        	termsAndConditionBos=managePartnerService.getTermsAndConditions();
			termsAndConditionDtos=new ArrayList<TermsAndConditionDto>();
			
			for(TermsAndConditionBo termsAndConditionBo:termsAndConditionBos){
				TermsAndConditionDto termsAndConditionDto=new TermsAndConditionDto();
				termsAndConditionDto.setTermsAndConditionId(termsAndConditionBo.getTermsAndConditionId());
				termsAndConditionDto.setMentainanceCharge(termsAndConditionBo.getCancellationCharge());
				termsAndConditionDto.setPerTicketFactor(termsAndConditionBo.getPerTicketFactor());
				termsAndConditionDto.setPerTicketFactorType(termsAndConditionBo.getPerTicketFactorType());
				termsAndConditionDto.setCancellationCharge(termsAndConditionBo.getCancellationCharge());
				termsAndConditionDtos.add(termsAndConditionDto);
			}
		
			return termsAndConditionDtos;
		}
		
}