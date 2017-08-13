package com.fyd.form;

/**
 *carry the 2ndPhaseRegistrationForm value of partner
* @author sidhartha
* @version 1.0
* @since 2017-05-10
* 
 */
public class PartnerOnlineUserForm {
 
 	protected String userName;
	protected String passWord;
	protected String confirmPassWord;
	protected int partnerId;
	protected int termsAndConditionId;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getConfirmPassWord() {
		return confirmPassWord;
	}
	public void setConfirmPassWord(String confirmPassWord) {
		this.confirmPassWord = confirmPassWord;
	}
	public int getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}
	public int getTermsAndConditionId() {
		return termsAndConditionId;
	}
	public void setTermsAndConditionId(int termsAndConditionId) {
		this.termsAndConditionId = termsAndConditionId;
	}
	@Override
	public String toString() {
		return "PartnerOnlineUserForm [userName=" + userName + ", passWord=" + passWord + ", confirmPassWord="
				+ confirmPassWord + ", partnerId=" + partnerId + ", termsAndConditionId=" + termsAndConditionId + "]";
	}
	
	
    	
}
