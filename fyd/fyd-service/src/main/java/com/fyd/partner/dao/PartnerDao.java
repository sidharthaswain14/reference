package com.fyd.partner.dao;

import java.util.List;

import com.fyd.partner.bo.AddressBo;
import com.fyd.partner.bo.PartnerOnlineUserBo;
import com.fyd.partner.bo.PartnerRegistrationBo;
import com.fyd.partner.bo.TermsAndConditionBo;
/**
 * 
 * @author sidhartha
 * @version 1.0
 * @since 15.5.2017
 *
 */
public interface PartnerDao {
	public void updatePartnerStatus(int PartnerNo,String status);
	public void updateOnlineUserStatus(String userName,String status);
	public int insertOnlineUser(PartnerOnlineUserBo onlineUserBo);
	public int selectRoleId();
	public void updateTermsAndConditionInPartner(int partnerNo, int termsAndConditionId);
	public int insertPartnerRegistraionInfo(PartnerRegistrationBo partnerRegistrationBo);
	public int insertAddress(AddressBo address);
	public List<TermsAndConditionBo> selectPartnerTermsAndcondition();
	public int selectPartnerNoByUserNameAndActivationCode(String userName,String activationCode);

}
