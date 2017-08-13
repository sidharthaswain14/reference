package com.fyd.partner.bo;

import java.sql.Date;
import java.sql.Timestamp;

public class PartnerRegistrationBo {

	protected String registeredName;
	protected String registrationNo;
	protected int estYear;
	protected String description;
	protected String primeryMobileNo;
	protected String secondaryMobileNo;
	protected String primeryEmailid;
	protected String secondaryEmailid;
	protected int primeryAddressId;
	protected int secondaryAddressId;
	protected String status;
	protected String createdBy;
	protected Timestamp createdDate;



	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
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

	public String getRegisteredName() {
		return registeredName;
	}

	public void setRegisteredName(String registeredName) {
		this.registeredName = registeredName;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public int getEstYear() {
		return estYear;
	}

	public void setEstYear(int estYear) {
		this.estYear = estYear;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrimeryMobileNo() {
		return primeryMobileNo;
	}

	public void setPrimeryMobileNo(String primeryMobileNo) {
		this.primeryMobileNo = primeryMobileNo;
	}

	public String getSecondaryMobileNo() {
		return secondaryMobileNo;
	}

	public void setSecondaryMobileNo(String secondaryMobileNo) {
		this.secondaryMobileNo = secondaryMobileNo;
	}

	public String getPrimeryEmailid() {
		return primeryEmailid;
	}

	public void setPrimeryEmailid(String primeryEmailid) {
		this.primeryEmailid = primeryEmailid;
	}

	public String getSecondaryEmailid() {
		return secondaryEmailid;
	}

	public void setSecondaryEmailid(String secondaryEmailid) {
		this.secondaryEmailid = secondaryEmailid;
	}

	public int getPrimeryAddressId() {
		return primeryAddressId;
	}

	public void setPrimeryAddressId(int primeryAddressId) {
		this.primeryAddressId = primeryAddressId;
	}

	public int getSecondaryAddressId() {
		return secondaryAddressId;
	}

	public void setSecondaryAddressId(int secondaryAddressId) {
		this.secondaryAddressId = secondaryAddressId;
	}

}
