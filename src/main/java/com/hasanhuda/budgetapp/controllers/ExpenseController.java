package com.hasanhuda.budgetapp.controllers;

import com.hasanhuda.budgetapp.models.Expense;
import com.hasanhuda.budgetapp.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable("id") String id) {
        Expense expense = expenseService.findById(id).orElse(null);
        return ResponseEntity.ok(expense);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getExpensesByUserId(@PathVariable("userId") String userId) {
        List<Expense> expenses = expenseService.findByUserId(userId);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/user/{userId}/category/{category}")
    public ResponseEntity<List<Expense>> getExpensesByUserIdAndCategory(@PathVariable("userId") String userId,
                                                                        @PathVariable("category") String category) {
        List<Expense> expenses = expenseService.findByUserIdAndCategory(userId, category);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/user/{userId}/{startDate}/{endDate}")
    public ResponseEntity<List<Expense>> getExpensesByUserIdAndDateRange(@PathVariable("userId") String userId,
                                                                         @PathVariable("startDate") String startDate,
                                                                         @PathVariable("endDate") String endDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = formatter.parse(startDate);
        Date end = formatter.parse(endDate);
        List<Expense> expenses = expenseService.findByUserIdAndDateRange(userId, start, end);
        return ResponseEntity.ok(expenses);
    }

    @PostMapping("/")
    public ResponseEntity<Expense> createExpense(@RequestBody Expense expense) {
        Expense newExpense = expenseService.save(expense);
        return ResponseEntity.ok(newExpense);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable("id") String id, @RequestBody Expense expense) {
        Expense existingExpense = expenseService.findById(id).orElse(null);
        if (existingExpense == null) {
            return ResponseEntity.notFound().build();
        }
        existingExpense.setCategory(expense.getCategory());
        existingExpense.setAmount(expense.getAmount());
        existingExpense.setDate(expense.getDate());
        Expense updatedExpense = expenseService.save(existingExpense);
        return ResponseEntity.ok(updatedExpense);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable("id") String id) {
        Expense existingExpense = expenseService.findById(id).orElse(null);
        if (existingExpense == null) {
            return ResponseEntity.notFound().build();
        }
        expenseService.delete(existingExpense);
        return ResponseEntity.ok().build();
    }
}


