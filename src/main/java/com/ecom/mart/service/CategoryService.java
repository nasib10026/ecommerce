package com.ecom.mart.service;

import com.ecom.mart.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    String createCategory(Category category);
    String deleteCategory(Long categoryId);
}
