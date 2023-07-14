package com.example.Restaurant_Management_Service_Api.repository;

import com.example.Restaurant_Management_Service_Api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepo extends JpaRepository<Order,Long> {
}
