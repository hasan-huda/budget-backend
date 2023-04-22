package com.hasanhuda.budgetapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "expenses")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Expense {
    @Id
    private String id;
    private String userId;
    private String category;
    private BigDecimal amount;
    private Date date;

}

