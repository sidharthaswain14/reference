package com.fyd.partner.dto;

import java.io.Serializable;

public class PartnerRegistrationDto implements Serializable {
	/*
	 * 
	 * @author sidhartha
	 * @version 1.0-SNAP-SHOT
	 * @since 2017-05-09
	 */
	private static final long serialVersionUID = 1L;
	protected String registeredName;
	protected String registrationNo;
	protected int estYear;
	protected String description;
	protected String primeryMobileNo;
	protected String secondaryMobileNo;
	protected String primeryEmailid;
	protected String secondaryEmailid;
	protected AddressDto primeryAddress;
	protected AddressDto secondaryAddress;

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

	public AddressDto getPrimeryAddress() {
		return primeryAddress;
	}

	public void setPrimeryAddress(AddressDto primeryAddress) {
		this.primeryAddress = primeryAddress;
	}

	public AddressDto getSecondaryAddress() {
		return secondaryAddress;
	}

	public void setSecondaryAddress(AddressDto secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

}
