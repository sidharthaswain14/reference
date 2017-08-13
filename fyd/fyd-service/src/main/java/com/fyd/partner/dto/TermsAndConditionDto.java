package com.fyd.partner.dto;

import java.util.Date;

public class TermsAndConditionDto {

	/* 
	 *@author sidhartha
	* @version 1.0
	* @since 2017-05-09 
	 */
	
	protected int termsAndConditionId;
	protected float mentainanceCharge;
	protected float perTicketFactor;
	protected String perTicketFactorType;
	protected float cancellationCharge;
	public int getTermsAndConditionId() {
		return termsAndConditionId;
	}
	public void setTermsAndConditionId(int termsAndConditionId) {
		this.termsAndConditionId = termsAndConditionId;
	}
	public float getMentainanceCharge() {
		return mentainanceCharge;
	}
	public void setMentainanceCharge(float mentainanceCharge) {
		this.mentainanceCharge = mentainanceCharge;
	}
	public float getPerTicketFactor() {
		return perTicketFactor;
	}
	public void setPerTicketFactor(float perTicketFactor) {
		this.perTicketFactor = perTicketFactor;
	}
	public String getPerTicketFactorType() {
		return perTicketFactorType;
	}
	public void setPerTicketFactorType(String perTicketFactorType) {
		this.perTicketFactorType = perTicketFactorType;
	}
	public float getCancellationCharge() {
		return cancellationCharge;
	}
	public void setCancellationCharge(float cancellationCharge) {
		this.cancellationCharge = cancellationCharge;
	}
	@Override
	public String toString() {
		return "TermsAndConditionDto [termsAndConditionId=" + termsAndConditionId + ", mentainanceCharge="
				+ mentainanceCharge + ", perTicketFactor=" + perTicketFactor + ", perTicketFactorType="
				+ perTicketFactorType + ", cancellationCharge=" + cancellationCharge + "]";
	}

	
}
