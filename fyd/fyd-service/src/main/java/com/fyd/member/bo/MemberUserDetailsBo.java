package com.fyd.member.bo;

public class MemberUserDetailsBo extends MemberBo {
	protected UserBo userBo;
	protected AuditBo auditBo;

	public UserBo getUserBo() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public AuditBo getAuditBo() {
		return auditBo;
	}

	public void setAuditBo(AuditBo auditBo) {
		this.auditBo = auditBo;
	}
}