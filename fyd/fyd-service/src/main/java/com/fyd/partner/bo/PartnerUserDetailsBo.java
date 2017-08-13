package com.fyd.partner.bo;

public class PartnerUserDetailsBo {

	protected int partnerNo;
	protected String userName;
	protected String passWord;
	protected int termsAndConditionId;

	
	
	
	public int getPartnerNo() {
		return partnerNo;
	}
	public void setPartnerNo(int partnerNo) {
		this.partnerNo = partnerNo;
	}
	
	
	public int getTermsAndConditionId() {
		return termsAndConditionId;
	}
	public void setTermsAndConditionId(int termsAndConditionId) {
		this.termsAndConditionId = termsAndConditionId;
	}
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
	
}
