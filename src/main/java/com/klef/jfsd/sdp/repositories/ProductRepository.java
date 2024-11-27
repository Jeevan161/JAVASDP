package com.klef.jfsd.sdp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.models.Member;
import com.klef.jfsd.sdp.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>
{
	 @Query("SELECT p FROM Product p WHERE p.member = :member")
	 List<Product> findProductsByMember(@Param("member") Member member);

}
