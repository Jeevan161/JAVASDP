package com.klef.jfsd.sdp.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.klef.jfsd.sdp.models.Member;

public class MemberInfoDetails implements UserDetails{

	private String email;
	private String password;
	private List<GrantedAuthority> role;
	private boolean isOTPVerified;
	private boolean isAdminVerified;
	public MemberInfoDetails(Member member)
	{
		this.isOTPVerified = member.isOtpVerified();
		this.isAdminVerified = member.isAdminVerified();
		this.email = member.getEmail();
		this.password = member.getPassword();
		this.role = Arrays.stream(member.getRole().split(","))
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.role;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean isOTPVerified() {
	    return this.isOTPVerified;
	}
	public boolean isAdminVerified() {
	    return this.isAdminVerified;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
