package com.fyd.partner.bo;

import java.sql.Date;
import java.sql.Timestamp;

public class PartnerOnlineUserBo {

	protected String userName;
	protected String passWord;
	protected int partnerNo;
	protected int roleId;
	protected String activationCode;
	protected String status;
	protected int termsAndConditionId;
	protected String createdBy;
	protected Timestamp createdDate;
	
	public String getUserName() {
		return userName;
	}
	public int getTermsAndConditionId() {
		return termsAndConditionId;
	}
	public void setTermsAndConditionId(int termsAndConditionId) {
		this.termsAndConditionId = termsAndConditionId;
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
	public int getPartnerNo() {
		return partnerNo;
	}
	public void setPartnerNo(int partnerNo) {
		this.partnerNo = partnerNo;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getActivationCode() {
		return activationCode;
	}
	public void setActivationCode(String activationCode) {
		this.activationCode = activationCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	
}
