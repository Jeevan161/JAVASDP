package com.klef.jfsd.sdp.services;

import com.klef.jfsd.sdp.models.SubCategory;
import com.klef.jfsd.sdp.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public SubCategory saveSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }
    @Override
    public List<SubCategory> getSubcategoriesById(int id) {
        // Implement logic to fetch subcategories by category ID
        // You can use subcategoryRepository or other methods here
        return subCategoryRepository.findAllByCategoryId(id);
    }
    @Override
    public SubCategory getSubCategoryById(int id) {
        return subCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public void deleteSubCategory(int id) {
        subCategoryRepository.deleteById(id);
    }
}
