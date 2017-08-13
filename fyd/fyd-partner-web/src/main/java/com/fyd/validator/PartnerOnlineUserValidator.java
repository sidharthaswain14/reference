package com.fyd.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fyd.form.PartnerOnlineUserForm;

@Component
public class PartnerOnlineUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(classType);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		PartnerOnlineUserForm partnerOnlineUserForm=null;
		partnerOnlineUserForm=(PartnerOnlineUserForm) obj;
		
		if(partnerOnlineUserForm.getPassWord()==null||"".equals(partnerOnlineUserForm.getPassWord().trim())){
			errors.rejectValue("passWord", "passWord.blank");
		}
		if(partnerOnlineUserForm.getConfirmPassWord()==null||"".equals(partnerOnlineUserForm.getConfirmPassWord().trim())){
			errors.rejectValue("confirmPassWord", "confirmPassWord.blank");
		}
		if(!(partnerOnlineUserForm.getPassWord().equals(partnerOnlineUserForm.getConfirmPassWord()))){
			errors.rejectValue("confirmPassWord", "confirmPassWord.missMatch");
		}
		if(partnerOnlineUserForm.getTermsAndConditionId()<=0){
			errors.rejectValue("termsAndConditionId","termsAndConditionId.blank");
		}
	}

}
