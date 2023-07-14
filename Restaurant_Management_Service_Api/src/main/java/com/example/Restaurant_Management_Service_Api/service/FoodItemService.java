package com.example.Restaurant_Management_Service_Api.service;

import com.example.Restaurant_Management_Service_Api.model.FoodItem;
import com.example.Restaurant_Management_Service_Api.model.User;
import com.example.Restaurant_Management_Service_Api.model.enums.UserRole;
import com.example.Restaurant_Management_Service_Api.repository.IFoodItemRepo;
import com.example.Restaurant_Management_Service_Api.repository.IUserRepo;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepo foodItemRepo;

    @Autowired
    IUserRepo userRepo;

    public FoodItem createFoodItem(FoodItem foodItem, Long userId) {

        // Check if the user is an admin
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        String newEmail = user.getUserEmail();
        UserRole role = user.getUserRole();
        if(!role.equals(UserRole.ADMIN) && !newEmail.endsWith(("@admin.com"))){
            throw new IllegalArgumentException("Only admins can create food items");
        }

        // Create the food item
        return foodItemRepo.save(foodItem);
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepo.findAll();
    }




}
