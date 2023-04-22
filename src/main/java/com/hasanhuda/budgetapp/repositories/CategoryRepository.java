package com.hasanhuda.budgetapp.repositories;

import com.hasanhuda.budgetapp.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {
    List<Category> findByUserId(String userId);
}
