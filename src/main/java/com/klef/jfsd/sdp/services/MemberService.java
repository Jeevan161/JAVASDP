package com.klef.jfsd.sdp.services;

import java.util.List;
import java.util.Optional;

import com.klef.jfsd.sdp.models.Member;

public interface MemberService {
	List<Member> findAllUsers();

	Optional<Member> findbyID(int sellerid);
	public List<Member> getUsersWithUnverifiedAdmin();
    
}
