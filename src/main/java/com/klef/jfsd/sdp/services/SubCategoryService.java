package com.klef.jfsd.sdp.services;

import java.util.List;

import com.klef.jfsd.sdp.models.SubCategory;

public interface SubCategoryService {
    SubCategory saveSubCategory(SubCategory subCategory);
    SubCategory getSubCategoryById(int id);
    List<SubCategory> getAllSubCategories();
    void deleteSubCategory(int id);
	List<SubCategory> getSubcategoriesById(int id);
}
