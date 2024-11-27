package com.klef.jfsd.sdp.repositories;

import com.klef.jfsd.sdp.models.SubCategory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

	 @Query("SELECT s FROM SubCategory s WHERE s.category.id = :categoryId")
	    List<SubCategory> findAllByCategoryId(@Param("categoryId") int categoryId);
    // You can add custom query methods here if needed
}
