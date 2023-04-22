package com.hasanhuda.budgetapp.repositories;

import com.hasanhuda.budgetapp.models.Budget;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface BudgetRepository extends MongoRepository<Budget, String> {
    List<Budget> findByUserId(String userId);
    List<Budget> findByUserIdAndStartDateGreaterThanEqualAndEndDateLessThanEqual(String userId, Date startDate, Date endDate);
}
