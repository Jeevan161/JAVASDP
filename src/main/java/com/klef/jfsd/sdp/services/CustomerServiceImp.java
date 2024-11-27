package com.klef.jfsd.sdp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.models.Customer;
import com.klef.jfsd.sdp.repositories.CustomerRepo;

@Service
public class CustomerServiceImp implements CustomerService{

	@Autowired
	private CustomerRepo memberRepo;
	
	@Override
	public List<Customer> findAllUsers() {
		 return memberRepo.findAllUsers();
	}

	@Override
	public Optional<Customer> findbyID(int sellerid) {
		return memberRepo.findById(sellerid);
	}

	@Override
	public List<Customer> getUsersWithUnverifiedAdmin() {
        return memberRepo.findUsersWithUnverifiedAdmin();
    }

}
