package com.ecom.mart.service;

import com.ecom.mart.model.Category;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    List<Category> categories = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Category> getAllCategories() {
        return categories;
    }

    @Override
    public String createCategory(Category category) {
        category.setCategoryId(nextId++);
        categories.add(category);
        return "successfully added";
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream().
        filter(c -> c.getCategoryId()
                .equals(categoryId)).findFirst().orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, " category not found"));
        categories.remove(category);
        return "successfully removed category with id: " + category.getCategoryId();
    }
}
