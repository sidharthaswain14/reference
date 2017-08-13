package com.fyd.util;

public interface FYDConstants {
	final String MEMBER_STATUS = "C";
	final String USER_STATUS = "D";
	final int ADMIN_ROLE = 1;
	final int PARTNER_ROLE = 2;
	final int MEMBER_ROLE = 3;
	final String CREATED_BY = "SYSTEM";
	final String LINK_PROTOCOL = "http://";
	final String NOTIFICATION_MAIL_ADDRESS = "noreply@s-force.org";
	final String NOTIFICATION_SUBJECT = "Find Your Destination Registration notification";
	final Object ACTIVATION_STATUS = "A";
	final Object LAST_MODIFIEDBY = "SYSTEM";
	
	final String partnerCreatedBy="SYSTEM";
	final String partnerDeactiveStatus="D";
	final String partnerActiveStatus="A";
	final String activeOnlineUserStatus="A";
	final String host="http://localhost";
	final String port=":8080";
	final String fydPartnerWebUri="/fyd-partner-web";
	final String partnerSecondPhaseRegistrationUri="/second-phase-partner-registration.htm";
	final String confirmPartnerRegistrationUri="/confirm-registration-controller.htm";
}
