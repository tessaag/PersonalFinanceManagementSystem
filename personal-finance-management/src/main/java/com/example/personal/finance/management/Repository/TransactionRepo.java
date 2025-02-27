package com.example.personal.finance.management.Repository;


import com.example.personal.finance.management.Models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface TransactionRepo extends JpaRepository<TransactionModel, Long> {

    @Query(value = "SELECT * FROM transactions WHERE user_id = ?1", nativeQuery = true)
    List<TransactionModel> findUserTransactions(int userId);

    @Query(value = "SELECT category, SUM(amount) as total FROM transactions WHERE user_id = ?1 GROUP BY category", nativeQuery = true)
    List<Map<String, Object>> getTotalExpensesByCategory(int userId);

}
