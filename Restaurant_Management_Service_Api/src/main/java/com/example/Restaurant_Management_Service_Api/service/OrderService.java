package com.example.Restaurant_Management_Service_Api.service;

import com.example.Restaurant_Management_Service_Api.model.Order;
import com.example.Restaurant_Management_Service_Api.model.User;
import com.example.Restaurant_Management_Service_Api.model.enums.UserRole;
import com.example.Restaurant_Management_Service_Api.repository.IOrderRepo;
import com.example.Restaurant_Management_Service_Api.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    IOrderRepo orderRepo;

    @Autowired
    IUserRepo userRepo;

    public Order generateFoodOrder(Order order, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        String newEmail = user.getUserEmail();
        UserRole role = user.getUserRole();
        if(!role.equals(UserRole.NORMAL_USER) && !newEmail.endsWith(("@gmail.com"))){
            throw new IllegalArgumentException("Only normal User can create food items");
        }

        // Create the food item
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }


}
