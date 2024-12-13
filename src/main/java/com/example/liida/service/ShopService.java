package com.example.liida.service;

import com.example.liida.model.Expense;
import com.example.liida.repository.ExpenseRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ShopService {
    private final ExpenseRepository expenseRepository;

    public ShopService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense){
        expenseRepository.save(expense);
    }

    public List<Expense> getShopItems(){
        return expenseRepository.findAll();
    }

    public void removeExpense(String name){
        expenseRepository.deleteByName(name);
    }

    @Scheduled(fixedRate = 10000)
    public double calculateShopTotal(){
        List<Expense> expenses = expenseRepository.findAll();
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.calculateTotal();
        }

        System.out.println("Scheduler total: " + total);
        return total;
    }
}