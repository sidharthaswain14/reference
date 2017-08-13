package com.fyd.partner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fyd.partner.bo.UserBo;
import com.fyd.partner.dao.PartnerDaoSecurity;
import com.fyd.partner.dto.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

	@Autowired
	protected PartnerDaoSecurity daoSecurity;
	
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		UserBo userBo=null;
		userBo=daoSecurity.findUserByName(userName);
		return new UserDetailsImpl(userBo.getUserName(), userBo.getPassWord(), userBo.getRoleName());
		
		
		//return null;
		
		/*if(userName.equals("sidhartha")){
			return new UserDetailsImpl(userName, "sid123", "ROLE_PARTNER");
		}else{
			throw new BadCredentialsException("invalid user name");
		}*/
		
		//return null;
	}

}
