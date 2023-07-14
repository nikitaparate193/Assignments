package com.example.Restaurant_Management_Service_Api.controller;

import com.example.Restaurant_Management_Service_Api.model.FoodItem;
import com.example.Restaurant_Management_Service_Api.model.Order;
import com.example.Restaurant_Management_Service_Api.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("order")
    public Order generateFoodOrder(@RequestBody Order order, @RequestParam Long userId) {
        return orderService.generateFoodOrder(order, userId);
    }

    @GetMapping("orders")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }


}
