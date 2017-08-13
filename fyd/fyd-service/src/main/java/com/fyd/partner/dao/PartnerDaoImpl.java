package com.fyd.partner.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.fyd.partner.bo.AddressBo;
import com.fyd.partner.bo.PartnerOnlineUserBo;
import com.fyd.partner.bo.PartnerRegistrationBo;
import com.fyd.partner.bo.TermsAndConditionBo;

/**
 * 
 * @author sidhartha
 *
 */

@Repository
public class PartnerDaoImpl implements PartnerDao {

	// accessing the active terms and condition
	private final String SQL_TERMS_AND_CONDITION = "SELECT PARTNER_AGREEMENT_TERMS_ID,MONTHLY_MAINTAINANCE_CHARGES,PER_TICKET_FACTOR,PER_TICKET_FACTOR_TYPE,CANCELLATION_CHARGES FROM partner_agreement_terms where status='A'";

	// upadate the partner terms and condition id in partner table
	private final String SQL_UPDATE_TERMS_AND_CONDITION_OF_PARTNER = "UPDATE partner SET `PARTNER_AGREEMENT_TERMS_ID`=? WHERE `PARTNER_NO`=?";

	// select role id of partner from user_role table
	private final String SQL_SELECT_ROLE_ID_PARTNER = "SELECT ROLE_ID FROM user_role where ROLE_CD='P'";
	
	//count the online user by giving activation code
	private final String SQL_PARTNER_NO_ONLINE_USER_VERIFYING_ACTIVATION_CODE="SELECT PARTNER_NO FROM online_users where USER_NM=? and ACTIVATION_CODE=?";
	
	//upadate partner status
	private final String SQL_UPDATE_PARTNER_STATUS="UPDATE partner SET `STATUS`=? WHERE `PARTNER_NO`=?";
	
	//update online user status
	private final String SQL_UPDATE_ONLINE_USERS_STATUS="UPDATE online_users SET `STATUS`=? WHERE `USER_NM`=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PartnerDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
	public int selectPartnerNoByUserNameAndActivationCode(String userName,String activationCode){
		return jdbcTemplate.queryForObject(SQL_PARTNER_NO_ONLINE_USER_VERIFYING_ACTIVATION_CODE, new Object[]{userName,activationCode}, Integer.class);
	}
	
	public void updatePartnerStatus(int PartnerNo,String status){
		
		jdbcTemplate.update(SQL_UPDATE_PARTNER_STATUS, new Object[]{status,PartnerNo});
	}
	public void updateOnlineUserStatus(String userName,String status){
		jdbcTemplate.update(SQL_UPDATE_ONLINE_USERS_STATUS,new Object[]{status,userName});
	}
	
	
	

	/**
	 * inserting the partnerOnline user Data into ONLINE_USER table
	 * 
	 * @param PartneronlineUserBo
	 * @return Integer
	 */
	public int insertOnlineUser(PartnerOnlineUserBo onlineUserBo) {

		KeyHolder keyHolder = null;
		keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new InsertOnlineRowMapper(onlineUserBo), keyHolder);

		return keyHolder.getKey().intValue();
	}

	// private final InsertOnlineUserPremparedStatementCreater

	private class InsertOnlineRowMapper implements PreparedStatementCreator {

		private final String SQL_INSERT_PARTNER_ONLINE_USER = "INSERT INTO online_users (`USER_NM`, `PASSWORD`, `PARTNER_NO`, `ROLE_ID`, `ACTIVATION_CODE`, `STATUS`, `CREATED_BY`, `CREATED_DT`) VALUES(?,?,?,?,?,?,?,?)";
		private PartnerOnlineUserBo onlineUserBo;

		public InsertOnlineRowMapper(PartnerOnlineUserBo onlineUserBo) {
			this.onlineUserBo = onlineUserBo;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(SQL_INSERT_PARTNER_ONLINE_USER, new String[] { "ONLINE_USER_ID" });

			pstmt.setString(1, onlineUserBo.getUserName());
			pstmt.setString(2, onlineUserBo.getPassWord());
			pstmt.setInt(3, onlineUserBo.getPartnerNo());
			pstmt.setInt(4, onlineUserBo.getRoleId());
			pstmt.setString(5, onlineUserBo.getActivationCode());
			pstmt.setString(6, onlineUserBo.getStatus());
			pstmt.setString(7, onlineUserBo.getCreatedBy());
			pstmt.setTimestamp(8, onlineUserBo.getCreatedDate());

			return pstmt;
		}

	}

	public int selectRoleId() {

		return jdbcTemplate.queryForObject(SQL_SELECT_ROLE_ID_PARTNER, Integer.class);
	}

	public void updateTermsAndConditionInPartner(int partnerNo, int termsAndConditionId) {

		jdbcTemplate.update(SQL_UPDATE_TERMS_AND_CONDITION_OF_PARTNER, new Object[] { termsAndConditionId, partnerNo });

	}

	// inserting the partner data in the partner table
	public int insertPartnerRegistraionInfo(PartnerRegistrationBo partnerRegistrationBo) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PartnerRegistrationPreparedStatementCreater(partnerRegistrationBo), keyHolder);
		return keyHolder.getKey().intValue();
	}

	// inserting the address data in address table
	public int insertAddress(AddressBo address) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new AddressPreparedStatementCreater(address), keyHolder);

		return keyHolder.getKey().intValue();

	}

	// for getting the terms and condition of the partner
	public List<TermsAndConditionBo> selectPartnerTermsAndcondition() {

		return jdbcTemplate.query(SQL_TERMS_AND_CONDITION, new RowMapper<TermsAndConditionBo>() {

			@Override
			public TermsAndConditionBo mapRow(ResultSet rs, int arg) throws SQLException {

				TermsAndConditionBo termsAndConditionBo = new TermsAndConditionBo();
				termsAndConditionBo.setTermsAndConditionId(rs.getInt(1));
				termsAndConditionBo.setMentainanceCharge(rs.getFloat(2));
				termsAndConditionBo.setPerTicketFactor(rs.getFloat(3));
				termsAndConditionBo.setPerTicketFactorType(rs.getString(4));
				termsAndConditionBo.setCancellationCharge(rs.getFloat(5));

				return termsAndConditionBo;
			}

		});

	}

	private final class PartnerRegistrationPreparedStatementCreater implements PreparedStatementCreator {

		private PartnerRegistrationBo partnerRegistrationBo;
		private final String INSERT_PARTNER = "INSERT INTO partner (`REGISTERED_NM`, `REGISTRATION_NO`, `EST_YEAR`,`DESCRIPTION`,`PRIMARY_ADDRESS_ID`,`SECONDARY_ADDRESS_ID`,`PRIMARY_CONTACT_NO`, `ALT_CONTACT_NO`,`PRIMARY_EMAIL_ADDR`,`ALT_EMAIL_ADDR`,`STATUS`,`CREATED_BY`,`CREATED_DT`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		public PartnerRegistrationPreparedStatementCreater(PartnerRegistrationBo partnerRegistrationBo) {
			this.partnerRegistrationBo = partnerRegistrationBo;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {

			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(INSERT_PARTNER, new String[] { "PARTNER_NO" });

			pstmt.setString(1, partnerRegistrationBo.getRegisteredName());
			pstmt.setString(2, partnerRegistrationBo.getRegistrationNo());
			pstmt.setInt(3, partnerRegistrationBo.getEstYear());
			pstmt.setString(4, partnerRegistrationBo.getDescription());
			pstmt.setInt(5, partnerRegistrationBo.getPrimeryAddressId());
			pstmt.setInt(6, partnerRegistrationBo.getSecondaryAddressId());
			pstmt.setString(7, partnerRegistrationBo.getPrimeryMobileNo());
			pstmt.setString(8, partnerRegistrationBo.getSecondaryMobileNo());
			pstmt.setString(9, partnerRegistrationBo.getPrimeryEmailid());
			pstmt.setString(10, partnerRegistrationBo.getSecondaryEmailid());
			pstmt.setString(11, partnerRegistrationBo.getStatus());
			pstmt.setString(12, partnerRegistrationBo.getCreatedBy());
			pstmt.setTimestamp(13,partnerRegistrationBo.getCreatedDate());
			
			return pstmt;
		}

	}

	private final class AddressPreparedStatementCreater implements PreparedStatementCreator {

		private AddressBo address;
		private final String INSERT_ADDRESS = "INSERT INTO address (`ADDRESS_LINE1`, `ADDRESS_LINE2`, `CITY`, `STATE`, `ZIP`, `COUNTRY`) VALUES (?, ?, ?, ?, ?, ?)";

		public AddressPreparedStatementCreater(AddressBo address) {
			this.address = address;
		}

		@Override
		public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(INSERT_ADDRESS, new String[] { "address_id" });
			pstmt.setString(1, address.getAddressLine1());
			pstmt.setString(2, address.getAddressLine2());
			pstmt.setString(3, address.getCity());
			pstmt.setString(4, address.getState());
			pstmt.setInt(5, address.getZip());
			pstmt.setString(6, address.getCountry());

			return pstmt;
		}

	}

}
