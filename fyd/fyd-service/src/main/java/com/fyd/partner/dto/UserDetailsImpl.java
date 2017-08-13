package com.fyd.partner.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 499115193795070529L;

	protected String userName;
	protected String passWord;
	protected String role;
	protected Collection<SimpleGrantedAuthority> authorities;
	
	public UserDetailsImpl(String userName, String passWord, String role) {
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
		
		authorities=new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role));
		
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return passWord;
	}

	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}

	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
