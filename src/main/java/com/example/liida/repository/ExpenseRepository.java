package com.example.liida.repository;

import com.example.liida.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
  void deleteByName(String name);
}