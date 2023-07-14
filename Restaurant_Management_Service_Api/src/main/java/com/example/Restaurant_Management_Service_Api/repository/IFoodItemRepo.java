package com.example.Restaurant_Management_Service_Api.repository;

import com.example.Restaurant_Management_Service_Api.model.FoodItem;
import com.example.Restaurant_Management_Service_Api.service.FoodItemService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodItemRepo extends JpaRepository<FoodItem,Long> {



}
