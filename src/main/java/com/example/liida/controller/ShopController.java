package com.example.liida.controller;

import com.example.liida.model.Expense;
import com.example.liida.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
public class ShopController {

    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public void addExpense(@RequestBody Expense expense) {
        service.addExpense(expense);
      //  return "Product " + expense.getName() + " added successfully";
    }

//    @PostMapping("/add")
//    public String addExpense(@RequestBody Expense expense) {
//        service.addExpense(expense);
//        return "Product " + expense.getName() + " added successfully";
//    }

    @GetMapping("/items")
    public List<Expense> getShopItems() {
        return service.getShopItems();

    }

    @DeleteMapping("/remove/{name}")
    public void removeExpense(@PathVariable String name) {
        service.removeExpense(name);

    }

    @GetMapping("/total")
    public double calculateShopTotal() {
        return service.calculateShopTotal();
    }
}