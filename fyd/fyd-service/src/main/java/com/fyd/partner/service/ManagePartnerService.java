package com.fyd.partner.service;

import java.util.List;

import com.fyd.partner.bo.PartnerUserDetailsBo;
import com.fyd.partner.bo.TermsAndConditionBo;
import com.fyd.partner.dto.PartnerRegistrationDto;

/**
 * 
 * @author sidhartha
 * @version 1.0
 * @since 17-5-2017
 *
 */
public interface ManagePartnerService {

	public void registerBasicInfo(PartnerRegistrationDto partnerRegistrationDto);

	public void registerUserDetails(PartnerUserDetailsBo userDetailsBo);

	public void activeAccount(String userName, String activationCode);

	public List<TermsAndConditionBo> getTermsAndConditions();

}
