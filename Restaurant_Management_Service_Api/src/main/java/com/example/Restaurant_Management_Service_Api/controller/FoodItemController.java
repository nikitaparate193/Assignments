package com.example.Restaurant_Management_Service_Api.controller;

import com.example.Restaurant_Management_Service_Api.model.FoodItem;
import com.example.Restaurant_Management_Service_Api.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FoodItemController {

    @Autowired
    FoodItemService foodItemService;

    @PostMapping("fooditem")
    public FoodItem createFoodItem(@RequestBody FoodItem foodItem, @RequestParam Long userId) {
        return foodItemService.createFoodItem(foodItem, userId);
    }

    @GetMapping("fooditems")
    public List<FoodItem> getAllFoodItems(){
        return foodItemService.getAllFoodItems();
    }




}
