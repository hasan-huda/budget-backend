package com.hasanhuda.budgetapp.services;

import com.hasanhuda.budgetapp.models.Expense;
import com.hasanhuda.budgetapp.repositories.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> findById(String id) {
        return expenseRepository.findById(id);
    }

    public List<Expense> findByUserId(String userId) {
        return expenseRepository.findByUserId(userId);
    }

    public List<Expense> findByUserIdAndCategory(String userId, String category) {
        return expenseRepository.findByUserIdAndCategory(userId, category);
    }

    public List<Expense> findByUserIdAndDateRange(String userId, Date startDate, Date endDate) {
        return expenseRepository.findByUserIdAndDateGreaterThanEqualAndDateLessThanEqual(userId, startDate, endDate);
    }

    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void delete(Expense expense) {
        expenseRepository.delete(expense);
    }
}
