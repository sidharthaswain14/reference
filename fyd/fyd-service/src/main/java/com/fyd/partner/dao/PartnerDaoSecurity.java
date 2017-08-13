package com.fyd.partner.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.fyd.partner.bo.UserBo;

@Repository
public class PartnerDaoSecurity {

	private String SQL_GET_USER_BY_NAME="select * FROM online_users U inner join user_role R ON U.ROLE_ID=R.ROLE_ID WHERE USER_NM=? ";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public PartnerDaoSecurity(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserBo findUserByName(String userName){
		
		return jdbcTemplate.queryForObject(SQL_GET_USER_BY_NAME, new RowMapper<UserBo>(){

			@Override
			public UserBo mapRow(ResultSet rs, int row) throws SQLException {

				UserBo userBo=new UserBo();
				userBo.setUserId(rs.getInt("ONLINE_USER_ID"));
				userBo.setUserName(rs.getString("USER_NM"));
				userBo.setPassWord(rs.getString("PASSWORD"));
				userBo.setRoleName(rs.getString("DESCRIPTION"));
				return userBo;
			}
			
		},new Object[]{userName});
		
	}
	
}
