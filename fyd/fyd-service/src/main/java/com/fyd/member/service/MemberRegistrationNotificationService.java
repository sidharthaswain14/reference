package com.fyd.member.service;

import com.fyd.member.bo.MemberBo;
import com.fyd.util.FYDConstants;
import com.fyd.util.mail.beans.MailMessage;

public class MemberRegistrationNotificationService {
	MailMessage mailMessage = null;

	public MailMessage getRegistrationMailMessage(MemberBo memberBo, String activationLink, String activationCode) {
		mailMessage = new MailMessage();
		mailMessage.setFrom(FYDConstants.NOTIFICATION_MAIL_ADDRESS);
		mailMessage.setTo(new String[] { memberBo.getEmailId() });
		mailMessage.setSubject(FYDConstants.NOTIFICATION_SUBJECT);
		mailMessage.setBody("Hi " + memberBo.getFirstName() + ","
				+ " You have successfully registered. Your activation code is \"" + activationCode + "\" Please verify your email by clicking on below provided link."
				+ " Link: " + activationLink);

		return mailMessage;
	}
}
