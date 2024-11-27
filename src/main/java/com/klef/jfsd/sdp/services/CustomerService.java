package com.klef.jfsd.sdp.services;

import java.util.List;
import java.util.Optional;

import com.klef.jfsd.sdp.models.Customer;

public interface CustomerService {
	List<Customer> findAllUsers();

	Optional<Customer> findbyID(int sellerid);
	public List<Customer> getUsersWithUnverifiedAdmin();
    
}
