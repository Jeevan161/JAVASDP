package com.klef.jfsd.sdp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.sdp.models.Member;

public interface MemberRepo extends JpaRepository<Member, Integer> {
	
	@Query(value="select * from user_table where user_email=?1",nativeQuery = true)
	Optional<Member> findByEmail(String email);
	 @Query(value = "SELECT * FROM user_table WHERE user_role = 'USER'", nativeQuery = true)
	 List<Member> findAllUsers();
	 @Query("SELECT m FROM Member m WHERE m.role = 'USER' AND m.adminVerified = false")
	    List<Member> findUsersWithUnverifiedAdmin();
}
