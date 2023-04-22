package com.hasanhuda.budgetapp.services;

import com.hasanhuda.budgetapp.models.Goal;
import com.hasanhuda.budgetapp.repositories.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public List<Goal> findAll() {
        return goalRepository.findAll();
    }

    public List<Goal> findByUserId(String userId) {
        return goalRepository.findByUserId(userId);
    }

    public Goal findById(String id) {
        Optional <Goal> optionalGoal = goalRepository.findById(id);
        if(optionalGoal.isEmpty()) return null;
        return optionalGoal.get();
    }

    public Goal save(Goal goal) {
        return goalRepository.save(goal);
    }

    public void delete(String id) {
        goalRepository.deleteById(id);
    }

}

