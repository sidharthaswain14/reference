package com.fyd.member.service;

import com.fyd.member.bo.MemberUserDetailsBo;

public interface ManageMemberService {
	public void registerMember(MemberUserDetailsBo memberUserDetailsBo, String host, int port, String uri);
	public String getUserInfo(int userId);
	public void updateUserStatus(int userId);
}
