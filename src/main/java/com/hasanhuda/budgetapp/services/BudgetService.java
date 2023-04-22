package com.hasanhuda.budgetapp.services;

import com.hasanhuda.budgetapp.models.Budget;
import com.hasanhuda.budgetapp.repositories.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public List<Budget> findAll() {
        return budgetRepository.findAll();
    }

    public Budget findById(String id) {
        Optional <Budget> optionalBudget = budgetRepository.findById(id);
        if(optionalBudget.isEmpty()) return null;
        return optionalBudget.get();
    }

    public List<Budget> findByUserId(String userId) {
        return budgetRepository.findByUserId(userId);
    }

    public Budget save(Budget budget) {
        return budgetRepository.save(budget);
    }

    public void delete(Budget budget) {
        budgetRepository.delete(budget);
    }
}
