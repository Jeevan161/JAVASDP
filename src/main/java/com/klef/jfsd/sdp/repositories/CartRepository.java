package com.klef.jfsd.sdp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.klef.jfsd.sdp.models.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c JOIN FETCH c.customer WHERE c.customer.email = :email")
    List<Cart> findCartItemsByCustomerEmail(@Param("email") String email);
}
