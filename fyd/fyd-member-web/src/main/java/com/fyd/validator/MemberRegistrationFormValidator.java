package com.fyd.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fyd.form.MemberRegistrationForm;

@Component
public class MemberRegistrationFormValidator implements Validator {
	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(MemberRegistrationForm.class);
	}

	@Override
	public void validate(Object object, Errors errors) {
		MemberRegistrationForm memberForm = null;
		
		memberForm = (MemberRegistrationForm) object;
		if(memberForm.getFirstName() == null || memberForm.getFirstName().trim().length() <= 0){
			errors.rejectValue("firstName", "firstName.blank");
		}
		if(memberForm.getLastName() == null || memberForm.getLastName().trim().length() <= 0){
			errors.rejectValue("lastName", "lastName.blank");
		}
		if(memberForm.getMobileNumber() == null || memberForm.getMobileNumber().trim().length() <= 0){
			errors.rejectValue("mobileNumber", "mobileNumber.blank");
		}
		if(memberForm.getEmailId() == null || memberForm.getEmailId().trim().length() <= 0){
			errors.rejectValue("emailId", "emailId.blank");
		}
		if(memberForm.getPassword() == null || memberForm.getPassword().trim().length() <= 0 ){
			errors.rejectValue("password", "password.blank");
		}
		if( memberForm.getPassword().trim().length() < 8){
			errors.rejectValue("password", "password.length");
		}
		if(!(memberForm.getPassword().equals(memberForm.getConfirmPassword()))){
			errors.rejectValue("password", "password.mismatch");
		}
	}
}
