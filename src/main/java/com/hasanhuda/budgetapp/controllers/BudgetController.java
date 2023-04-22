package com.hasanhuda.budgetapp.controllers;

import com.hasanhuda.budgetapp.models.Budget;
import com.hasanhuda.budgetapp.services.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @GetMapping("")
    public List<Budget> getAllBudgets() {
        return budgetService.findAll();
    }

    @GetMapping("/budget/{id}")
    public ResponseEntity<Budget> getBudgetById(@PathVariable String id) {
        Budget budget = budgetService.findById(id);
        if (budget == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(budget);
    }


    @GetMapping("/user/{userId}")
    public List<Budget> getBudgetsByUserId(@PathVariable String userId) {
        return budgetService.findByUserId(userId);
    }

    @PostMapping("")
    public ResponseEntity<Budget> createBudget(@RequestBody Budget budget) {
        Budget newBudget = budgetService.save(budget);
        return ResponseEntity.ok(newBudget);
    }

    @PutMapping("/budget/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable String id, @RequestBody Budget updatedBudget) {
        Budget budget = budgetService.findById(id);
        if (budget == null) {
            return ResponseEntity.notFound().build();
        }
        if (updatedBudget.getStartDate() != null) {
            budget.setStartDate(updatedBudget.getStartDate());
        }
        if (updatedBudget.getEndDate() != null) {
            budget.setEndDate(updatedBudget.getEndDate());
        }
        if (updatedBudget.getLimit() != null) {
            budget.setLimit(updatedBudget.getLimit());
        }
        if (updatedBudget.getTransactions() != null) {
            budget.setTransactions(updatedBudget.getTransactions());
        }
        if (updatedBudget.getCategoryId() != null) {
            budget.setCategoryId(updatedBudget.getCategoryId());
        }
        if (updatedBudget.getTotal() != null) {
            budget.setTotal(updatedBudget.getTotal());
        }

        Budget savedBudget = budgetService.save(budget);
        return ResponseEntity.ok(savedBudget);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBudget(@PathVariable String id) {
        Budget budget = budgetService.findById(id);
        if (budget != null) {
            budgetService.delete(budget);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
