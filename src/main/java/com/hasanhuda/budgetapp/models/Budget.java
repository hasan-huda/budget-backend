package com.hasanhuda.budgetapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "budgets")
@AllArgsConstructor
@Data
public class Budget {
    @Id
    private String id;
    private String userId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal limit;
    private List<String> transactions;
    private String categoryId;
    private BigDecimal total;
}
