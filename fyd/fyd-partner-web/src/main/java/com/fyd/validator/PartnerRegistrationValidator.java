package com.fyd.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fyd.form.PartnerRegistrationForm;

@Component
public class PartnerRegistrationValidator implements Validator{

	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(classType);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		PartnerRegistrationForm partnerRegistrationForm=null;
		partnerRegistrationForm=(PartnerRegistrationForm) obj;
		
		if(partnerRegistrationForm.getRegisteredName()==null||"".equals(partnerRegistrationForm.getRegisteredName().trim())){
			errors.rejectValue("registeredName", "registeredName.blank");
		}
		if(partnerRegistrationForm.getRegistrationNo()==null||"".equals(partnerRegistrationForm.getRegistrationNo().trim())){
			errors.rejectValue("registrationNo","registrationNo.blank");
		}
		if(partnerRegistrationForm.getEstYear()<=0||"".equals(String.valueOf(partnerRegistrationForm.getEstYear()).trim())){
			errors.rejectValue("estYear","estYear.blank");
		}
		
		if(partnerRegistrationForm.getDescription()==null||"".equals(partnerRegistrationForm.getDescription().trim())){
			errors.rejectValue("description","descriprtion.blank");
		}
		if(partnerRegistrationForm.getPrimeryMobileNo()==null||"".equals(partnerRegistrationForm.getPrimeryMobileNo().trim())){
			errors.rejectValue("primeryMobileNo", "primeryMobileNo.blank");
		}
		if(partnerRegistrationForm.getPrimeryEmailid()==null||"".equals(partnerRegistrationForm.getPrimeryEmailid().trim())){
			errors.rejectValue("primeryEmailid", "primeryEmailid.blank");
		}
		if(partnerRegistrationForm.getPrimeryAddressLine1()==null||"".equals(partnerRegistrationForm.getPrimeryAddressLine1().trim())){
			errors.rejectValue("primeryAddressLine1", "primeryAddressLine1.blank");
		}
		if(partnerRegistrationForm.getPrimeryCity()==null||"".equals(partnerRegistrationForm.getPrimeryCity().trim())){
			errors.rejectValue("primeryCity", "primeryCity.blank");
		}
		if(partnerRegistrationForm.getPrimeryState()==null||"".equals(partnerRegistrationForm.getPrimeryState().trim())){
			errors.rejectValue("primeryState", "primeryState.blank");
		}
		if(partnerRegistrationForm.getPrimeryZip()<=0||"".equals(String.valueOf(partnerRegistrationForm.getPrimeryZip()).trim())){
			errors.rejectValue("primeryZip", "primeryZip.blank");
		}
		if(partnerRegistrationForm.getPrimeryCountry()==null||"".equals(partnerRegistrationForm.getPrimeryCountry().trim())){
			errors.rejectValue("primeryCountry", "primeryCountry.blank");
		}
	}

}
