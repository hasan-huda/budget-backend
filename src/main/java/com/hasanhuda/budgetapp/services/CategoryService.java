package com.hasanhuda.budgetapp.services;

import com.hasanhuda.budgetapp.models.Category;
import com.hasanhuda.budgetapp.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategoriesForUser(String userId) {
        return categoryRepository.findByUserId(userId);
    }

    public Category getCategoryById(String categoryId) {
        return categoryRepository.findById(categoryId).orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(String categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}

