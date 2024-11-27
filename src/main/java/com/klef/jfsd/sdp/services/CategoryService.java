package com.klef.jfsd.sdp.services;

import java.util.List;

import com.klef.jfsd.sdp.models.Category;

public interface CategoryService {
    Category saveCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    void deleteCategory(int id);
}
