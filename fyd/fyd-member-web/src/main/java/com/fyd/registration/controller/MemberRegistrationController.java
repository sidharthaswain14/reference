package com.fyd.registration.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fyd.form.MemberRegistrationForm;
import com.fyd.member.bo.AuditBo;
import com.fyd.member.bo.MemberUserDetailsBo;
import com.fyd.member.bo.UserBo;
import com.fyd.member.service.ManageMemberService;
import com.fyd.util.FYDConstants;
import com.fyd.validator.MemberRegistrationFormValidator;

@Controller
@RequestMapping("/member-registration.htm")
public class MemberRegistrationController {
	
	@Autowired
	private MemberRegistrationFormValidator memberRegistrationFormValidator;
	
	@Autowired
	private ManageMemberService manageMemberService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showMemberRegistrationForm(Model model) {
		MemberRegistrationForm memberRegistrationForm = null;

		memberRegistrationForm = new MemberRegistrationForm();
		model.addAttribute("memberRegistrationForm", memberRegistrationForm);
		return "member-registration-definition";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registerMember(Model model,
			@ModelAttribute("memberRegistrationForm") MemberRegistrationForm memberForm, BindingResult errors, HttpServletRequest request){
		
		memberRegistrationFormValidator.validate(memberForm, errors);
		MemberUserDetailsBo detailsBo = null;
		AuditBo auditBo = null;
		UserBo userBo = null;
		
		if (errors.hasErrors()) {
			// if errors are there display back the source page
			return "member-registration-definition";
		}

		// if no errors are there
		auditBo = new AuditBo();
		auditBo.setCreatedBy(FYDConstants.CREATED_BY);
		auditBo.setCreatedDate(new Date());
		
		String host = request.getRemoteHost();
		int port = request.getServerPort();
		String[] uri = request.getRequestURI().split("/");
		
		userBo = new UserBo();
		userBo.setUserName(memberForm.getEmailId());
		userBo.setPassword(memberForm.getPassword());
		userBo.setRoleId(FYDConstants.MEMBER_ROLE);
		userBo.setActivationDate(new Date());
		userBo.setStatus(FYDConstants.USER_STATUS);
		
 		detailsBo = new MemberUserDetailsBo();
 		detailsBo.setFirstName(memberForm.getFirstName());
 		detailsBo.setLastName(memberForm.getLastName());
 		detailsBo.setEmailId(memberForm.getEmailId());
 		detailsBo.setMobileNumber(memberForm.getMobileNumber());
 		detailsBo.setRegisteredDate(new Date());
 		detailsBo.setStatus(FYDConstants.MEMBER_STATUS);
 		detailsBo.setUserBo(userBo);
 		detailsBo.setAuditBo(auditBo);
		
		manageMemberService.registerMember(detailsBo, host, port, uri[1]);
		return "registration-success-definition";
	}
}
