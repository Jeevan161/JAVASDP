package com.klef.jfsd.sdp.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.repositories.MemberRepo;

@Service
public class MemberInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private MemberRepo memberrepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Member> user = memberrepo.findByEmail(username);
		return user.map(MemberInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User Does not exist"));
	}

}
