package com.fyd.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fyd.member.bo.MemberBo;
import com.fyd.member.bo.MemberUserDetailsBo;
import com.fyd.member.bo.UserBo;
import com.fyd.member.dao.MemberDao;
import com.fyd.util.FYDConstants;
import com.fyd.util.codegenerator.ActivationCodeGenerator;
import com.fyd.util.mail.beans.MailMessage;
import com.fyd.util.mail.service.NotificationManager;

@Service
public class ManageMemberServiceImpl implements ManageMemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private NotificationManager notificationManager;
	
	@Override
	public void registerMember(MemberUserDetailsBo memberUserDetailsBo, String host, int port, String uri){
		MemberBo memberBo = null;
		UserBo userBo = null;
		MailMessage mailMessage = null;
		String activationLink = null;
		MemberRegistrationNotificationService notificationService = null;
		
		memberBo = new MemberBo();
		memberBo.setFirstName(memberUserDetailsBo.getFirstName());
		memberBo.setLastName(memberUserDetailsBo.getLastName());
		memberBo.setMobileNumber(memberUserDetailsBo.getMobileNumber());
		memberBo.setEmailId(memberUserDetailsBo.getEmailId());
		memberBo.setStatus(memberUserDetailsBo.getStatus());
		memberBo.setRegisteredDate(memberUserDetailsBo.getRegisteredDate());
		memberBo.setAuditBo(memberUserDetailsBo.getAuditBo());
		int memberId = memberDao.saveMember(memberBo);
		
		userBo = new UserBo();
		userBo.setMemberId(memberId);
		userBo.setUserName(memberUserDetailsBo.getUserBo().getUserName());
		userBo.setPassword(memberUserDetailsBo.getUserBo().getPassword());
		userBo.setRoleId(memberUserDetailsBo.getUserBo().getRoleId());
		userBo.setActivationCode(ActivationCodeGenerator.generateActivationCode());
		userBo.setActivationDate(memberUserDetailsBo.getUserBo().getActivationDate());
		userBo.setTerminationDate(memberUserDetailsBo.getUserBo().getTerminationDate());
		userBo.setStatus(memberUserDetailsBo.getUserBo().getStatus());
		userBo.setAuditBo(memberUserDetailsBo.getAuditBo());
		int userId = memberDao.saveUserInfo(userBo);
		
		activationLink = buildActivtionLink(host, port, uri, userId);
		
		notificationService = new MemberRegistrationNotificationService();
		mailMessage = notificationService.getRegistrationMailMessage(memberBo, activationLink, userBo.getActivationCode());
		notificationManager.send(mailMessage);
	}

	private String buildActivtionLink(String host, int port, String uri, int userId) {
		StringBuffer link = new StringBuffer();
		link.append(FYDConstants.LINK_PROTOCOL).append(host).append(":").append(port).append("/").append(uri).append("/member-account-activation.htm?userId=").append(userId);
		
		return link.toString();
	}

	@Override
	public String getUserInfo(int userId) {
		return memberDao.getUserInfo(userId);
	}

	@Override
	public void updateUserStatus(int userId) {
		memberDao.updateUserInfo(userId);
	}
}
