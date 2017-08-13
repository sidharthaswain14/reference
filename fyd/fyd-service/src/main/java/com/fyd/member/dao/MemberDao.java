package com.fyd.member.dao;

import org.springframework.stereotype.Repository;

import com.fyd.member.bo.MemberBo;
import com.fyd.member.bo.UserBo;

@Repository
public interface MemberDao {
	public int saveMember(MemberBo memberBo);
	public int saveUserInfo(UserBo userBo);
	public String getUserInfo(int userId);
	public void updateUserInfo(int userId);
}
