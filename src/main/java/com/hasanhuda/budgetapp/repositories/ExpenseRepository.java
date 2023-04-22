package com.hasanhuda.budgetapp.repositories;

import com.hasanhuda.budgetapp.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    List<Expense> findByUserId(String userId);
    List<Expense> findByUserIdAndCategory(String userId, String category);
    List<Expense> findByUserIdAndDateGreaterThanEqualAndDateLessThanEqual(String userId, Date startDate, Date endDate);
}
