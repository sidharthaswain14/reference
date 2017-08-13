package com.fyd.member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.fyd.member.bo.MemberBo;
import com.fyd.member.bo.UserBo;
import com.fyd.util.FYDConstants;
import com.mysql.jdbc.Statement;

@Repository
public class MemberDaoImpl implements MemberDao {
	private final String SQL_SAVE_MEMBER = "insert into findyourdestination_db.member(member_nm, mobile, email_address, registered_dt, status, created_by, created_dt) values(?,?,?,?,?,?,?)";
	private final String SQL_SAVE_USER_DETAILS = "insert into findyourdestination_db.online_users(user_nm, password, member_id, role_id, activation_dt, activation_code, status, created_by, created_dt) values(?,?,?,?,?,?,?,?,?)";
	private final String SQL_GET_USERINFO = "select activation_code from online_users where online_user_id=?";
	private final String SQL_UPDATE_USERINFO = "update online_users set status=?, last_modified_by=?, last_modified_dt=curdate() where online_user_id=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int saveMember(MemberBo memberBo) {

		GeneratedKeyHolder memberKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PSMemberCreator(memberBo), memberKeyHolder);

		return memberKeyHolder.getKey().intValue();
	}

	@Override
	public int saveUserInfo(UserBo userBo) {
		GeneratedKeyHolder userKeyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PSUserCreator(userBo), userKeyHolder);

		return userKeyHolder.getKey().intValue();
	}

	private class PSMemberCreator implements PreparedStatementCreator {
		MemberBo memberBo = null;

		public PSMemberCreator(MemberBo memberBo) {
			this.memberBo = memberBo;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement preparedStatement = con.prepareStatement(SQL_SAVE_MEMBER,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, memberBo.getFirstName() + memberBo.getLastName());
			preparedStatement.setString(2, memberBo.getMobileNumber());
			preparedStatement.setString(3, memberBo.getEmailId());
			preparedStatement.setDate(4, new Date(memberBo.getRegisteredDate().getTime()));
			preparedStatement.setString(5, memberBo.getStatus());
			preparedStatement.setString(6, memberBo.getAuditBo().getCreatedBy());
			preparedStatement.setDate(7, new Date(memberBo.getAuditBo().getCreatedDate().getTime()));

			return preparedStatement;
		}
	}

	private class PSUserCreator implements PreparedStatementCreator {
		UserBo userBo = null;

		public PSUserCreator(UserBo userBo) {
			this.userBo = userBo;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			PreparedStatement preparedStatement = con.prepareStatement(SQL_SAVE_USER_DETAILS,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, userBo.getUserName());
			preparedStatement.setString(2, userBo.getPassword());
			preparedStatement.setInt(3, userBo.getMemberId());
			preparedStatement.setInt(4, userBo.getRoleId());
			preparedStatement.setDate(5, new Date(userBo.getActivationDate().getTime()));
			preparedStatement.setString(6, userBo.getActivationCode());
			preparedStatement.setString(7, userBo.getStatus());
			preparedStatement.setString(8, userBo.getAuditBo().getCreatedBy());
			preparedStatement.setDate(9, new Date(userBo.getAuditBo().getCreatedDate().getTime()));

			return preparedStatement;
		}
	}

	@Override
	public String getUserInfo(int userId) {
		return jdbcTemplate.queryForObject(SQL_GET_USERINFO, String.class, new Object[] { userId });
	}

	@Override
	public void updateUserInfo(int userId) {
		jdbcTemplate.update(SQL_UPDATE_USERINFO, new Object[]{userId, FYDConstants.ACTIVATION_STATUS, FYDConstants.LAST_MODIFIEDBY});
	}
}
