package com.klef.jfsd.sdp.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.sdp.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	
	@Query(value="select * from user_table where user_email=?1",nativeQuery = true)
	Optional<Customer> findByEmail(String email);
	 @Query(value = "SELECT * FROM user_table WHERE user_role = 'USER'", nativeQuery = true)
	 List<Customer> findAllUsers();
	 @Query("SELECT m FROM Member m WHERE m.role = 'USER' AND m.adminVerified = false")
	    List<Customer> findUsersWithUnverifiedAdmin();
}
