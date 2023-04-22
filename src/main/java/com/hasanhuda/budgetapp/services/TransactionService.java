package com.hasanhuda.budgetapp.services;

import com.hasanhuda.budgetapp.models.Transaction;
import com.hasanhuda.budgetapp.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> getAllTransactionsForUser(String userId) {
        return transactionRepository.findByUserId(userId);
    }

    public Optional<Transaction> findById(String id) {
        return transactionRepository.findById(id);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void delete(Transaction transaction) {
        transactionRepository.delete(transaction);
    }
    public List<Transaction> findByUserId(String userId) {
        return transactionRepository.findByUserId(userId);
    }
}

