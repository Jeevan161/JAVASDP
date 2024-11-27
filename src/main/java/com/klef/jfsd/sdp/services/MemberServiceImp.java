package com.klef.jfsd.sdp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.repositories.MemberRepo;

@Service
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberRepo memberRepo;
	
	@Override
	public List<Member> findAllUsers() {
		 return memberRepo.findAllUsers();
	}

	@Override
	public Optional<Member> findbyID(int sellerid) {
		return memberRepo.findById(sellerid);
	}

	@Override
	public List<Member> getUsersWithUnverifiedAdmin() {
        return memberRepo.findUsersWithUnverifiedAdmin();
    }

}
