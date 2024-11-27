package com.klef.jfsd.sdp.repositories;

import com.klef.jfsd.sdp.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // You can add custom query methods here if needed
}
