package com.fyd.member.bo;

import java.util.Date;

public class MemberBo {
	protected String firstName;
	protected String lastName;
	protected String mobileNumber;
	protected String emailId;
	protected Date registeredDate;
	protected String status;
	protected AuditBo auditBo;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public AuditBo getAuditBo() {
		return auditBo;
	}

	public void setAuditBo(AuditBo auditBo) {
		this.auditBo = auditBo;
	}
}
