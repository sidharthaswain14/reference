package com.fyd.partner.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fyd.partner.bo.AddressBo;
import com.fyd.partner.bo.PartnerOnlineUserBo;
import com.fyd.partner.bo.PartnerRegistrationBo;
import com.fyd.partner.bo.PartnerUserDetailsBo;
import com.fyd.partner.bo.TermsAndConditionBo;
import com.fyd.partner.dao.PartnerDao;
import com.fyd.partner.dao.PartnerDaoImpl;
import com.fyd.partner.dto.PartnerRegistrationDto;
import com.fyd.util.FYDConstants;
import com.fyd.util.codegenerator.ActivationCodeGenerator;
import com.fyd.util.mail.beans.MailMessage;
import com.fyd.util.mail.service.NotificationManager;

@Service
public class ManagePartnerServiceImpl implements ManagePartnerService {

	@Autowired
	private PartnerDao partnerDao;
	@Autowired
	private NotificationManager mailNotificationManage;
	
	@Autowired
    private PasswordEncoder bCryptPassWordEncoder;
	

	// register partner basic info
	public void registerBasicInfo(PartnerRegistrationDto partnerRegistrationDto) {
		PartnerRegistrationBo partnerRegistrationBo = null;
		AddressBo primeryAddressBo = null;
		AddressBo secondaryAddressBo = null;
		int partnerRegistrationId = 0;

		partnerRegistrationBo = new PartnerRegistrationBo();
		partnerRegistrationBo.setRegisteredName(partnerRegistrationDto.getRegisteredName());
		partnerRegistrationBo.setRegistrationNo(partnerRegistrationDto.getRegistrationNo());
		partnerRegistrationBo.setEstYear(partnerRegistrationDto.getEstYear());
		partnerRegistrationBo.setDescription(partnerRegistrationDto.getDescription());
		partnerRegistrationBo.setPrimeryMobileNo(partnerRegistrationDto.getPrimeryMobileNo());
		partnerRegistrationBo.setSecondaryMobileNo(partnerRegistrationDto.getSecondaryMobileNo());
		partnerRegistrationBo.setPrimeryEmailid(partnerRegistrationDto.getPrimeryEmailid());
		partnerRegistrationBo.setSecondaryEmailid(partnerRegistrationDto.getSecondaryEmailid());

		// get the primeryAddressId from addressTable
		if (partnerRegistrationDto.getPrimeryAddress() != null) {
			primeryAddressBo = new AddressBo();
			primeryAddressBo.setAddressLine1(partnerRegistrationDto.getPrimeryAddress().getAddressLine1());
			primeryAddressBo.setAddressLine2(partnerRegistrationDto.getPrimeryAddress().getAddressLine2());
			primeryAddressBo.setCity(partnerRegistrationDto.getPrimeryAddress().getCity());
			primeryAddressBo.setState(partnerRegistrationDto.getPrimeryAddress().getState());
			primeryAddressBo.setZip(partnerRegistrationDto.getPrimeryAddress().getZip());
			primeryAddressBo.setCountry(partnerRegistrationDto.getPrimeryAddress().getCountry());

			partnerRegistrationBo.setPrimeryAddressId(partnerDao.insertAddress(primeryAddressBo));
		}
		// if secondary address exist then get the secondaryAddressId from
		// address table

		if (partnerRegistrationDto.getSecondaryAddress() != null) {
			secondaryAddressBo = new AddressBo();
			secondaryAddressBo.setAddressLine1(partnerRegistrationDto.getSecondaryAddress().getAddressLine1());
			secondaryAddressBo.setAddressLine2(partnerRegistrationDto.getSecondaryAddress().getAddressLine2());
			secondaryAddressBo.setCity(partnerRegistrationDto.getSecondaryAddress().getCity());
			secondaryAddressBo.setState(partnerRegistrationDto.getSecondaryAddress().getState());
			secondaryAddressBo.setZip(partnerRegistrationDto.getSecondaryAddress().getZip());
			secondaryAddressBo.setCountry(partnerRegistrationDto.getSecondaryAddress().getCountry());

			partnerRegistrationBo.setSecondaryAddressId(partnerDao.insertAddress(secondaryAddressBo));
		}

		if (partnerRegistrationBo.getSecondaryAddressId() == 0) {
			partnerRegistrationBo.setSecondaryAddressId(partnerRegistrationBo.getPrimeryAddressId());
		}

		partnerRegistrationBo.setStatus(FYDConstants.partnerDeactiveStatus);
		partnerRegistrationBo.setCreatedBy(FYDConstants.partnerCreatedBy);
		partnerRegistrationBo.setCreatedDate(new Timestamp(System.currentTimeMillis()));

		partnerRegistrationId = partnerDao.insertPartnerRegistraionInfo(partnerRegistrationBo);

		// call the mail service to partner go for second phase registration
		// http://localhost:8080/context_path/second-phase-partner-registration.htm?partnerId=partnerId&emaiId=primeryEmailId

		MailMessage mailMessage = null;
		mailMessage = new MailMessage();
		mailMessage.setFrom(FYDConstants.NOTIFICATION_MAIL_ADDRESS);
		mailMessage.setTo(new String[] { partnerRegistrationDto.getPrimeryEmailid() });
		mailMessage.setSubject("PARTNER SECONDARY REGISTRATION");
		mailMessage.setBody("Go for second phase Registration open the link " + FYDConstants.host + FYDConstants.port
				+ FYDConstants.fydPartnerWebUri + FYDConstants.partnerSecondPhaseRegistrationUri + "?" + "partnerId="
				+ partnerRegistrationId + "&" + "emailId=" + partnerRegistrationDto.getPrimeryEmailid());

		mailNotificationManage.send(mailMessage);

	}

	public void registerUserDetails(PartnerUserDetailsBo userDetailsBo) {
		PartnerOnlineUserBo onlineUserBo = null;

		partnerDao.updateTermsAndConditionInPartner(userDetailsBo.getPartnerNo(),
				userDetailsBo.getTermsAndConditionId());

		onlineUserBo = new PartnerOnlineUserBo();
		onlineUserBo.setUserName(userDetailsBo.getUserName());
		onlineUserBo.setPassWord(bCryptPassWordEncoder.encode(userDetailsBo.getPassWord()));
		onlineUserBo.setRoleId(partnerDao.selectRoleId());
		onlineUserBo.setStatus(FYDConstants.partnerDeactiveStatus);
		onlineUserBo.setPartnerNo(userDetailsBo.getPartnerNo());
		onlineUserBo.setCreatedBy(FYDConstants.partnerCreatedBy);
		onlineUserBo.setCreatedDate(new Timestamp(System.currentTimeMillis()));

		// get the activation code
		// activation code length should be 5
		String activationCode =ActivationCodeGenerator.generateActivationCode();
		onlineUserBo.setActivationCode(activationCode);
		partnerDao.insertOnlineUser(onlineUserBo);

		// send the mail as
		// contextpath/second-phase-partner-registration.htm?activationCode="some
		// value"&userName="emaiId"
		MailMessage mailMessage = null;
		mailMessage = new MailMessage();
		mailMessage.setFrom(FYDConstants.NOTIFICATION_MAIL_ADDRESS);
		mailMessage.setTo(new String[] { userDetailsBo.getUserName() });
		mailMessage.setSubject("PARTNER CONFIRM REGISTRATION");
		mailMessage.setBody("Complete your registration open the link " + FYDConstants.host + FYDConstants.port
				+ FYDConstants.fydPartnerWebUri + FYDConstants.confirmPartnerRegistrationUri + "?" + "userName="
				+ onlineUserBo.getUserName() + "&activationCode=" + activationCode);
		mailNotificationManage.send(mailMessage);

	}

	public void activeAccount(String userName, String activationCode) {

		partnerDao.updatePartnerStatus(partnerDao.selectPartnerNoByUserNameAndActivationCode(userName, activationCode),
				FYDConstants.partnerActiveStatus);
		partnerDao.updateOnlineUserStatus(userName, FYDConstants.activeOnlineUserStatus);

	}

	// get the list of terms and conditions

	public List<TermsAndConditionBo> getTermsAndConditions() {
		return partnerDao.selectPartnerTermsAndcondition();
	}

}
