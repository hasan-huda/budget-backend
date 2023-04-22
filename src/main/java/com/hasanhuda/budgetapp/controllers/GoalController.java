package com.hasanhuda.budgetapp.controllers;

import com.hasanhuda.budgetapp.models.Goal;
import com.hasanhuda.budgetapp.services.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @GetMapping("")
    public List<Goal> getAllGoals() {
        return goalService.findAll();
    }

    @GetMapping("/goal/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable("id") String id) {
        Goal goal = goalService.findById(id);
        return ResponseEntity.ok(goal);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Goal>> getGoalsByUserId(@PathVariable("userId") String userId) {
        List<Goal> goals = goalService.findByUserId(userId);
        return ResponseEntity.ok(goals);
    }

    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal newGoal = goalService.save(goal);
        return ResponseEntity.ok(newGoal);
    }

    @PutMapping("/goal/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable("id") String id, @RequestBody Goal updatedGoal) {
        Goal goal = goalService.findById(id);
        if (goal == null) {
            return ResponseEntity.notFound().build();
        }
        goal.setName(updatedGoal.getName());
        goal.setTargetAmount(updatedGoal.getTargetAmount());
        goal.setCurrentAmount(updatedGoal.getCurrentAmount());
        goal.setDueDate(updatedGoal.getDueDate());
        goal.setPaused(updatedGoal.isPaused()); // new line to set isPaused field

        Goal savedGoal = goalService.save(goal);
        return ResponseEntity.ok(savedGoal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable("id") String id) {
        goalService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
