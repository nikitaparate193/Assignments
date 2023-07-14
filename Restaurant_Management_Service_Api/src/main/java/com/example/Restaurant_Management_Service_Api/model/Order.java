package com.example.Restaurant_Management_Service_Api.model;

import com.example.Restaurant_Management_Service_Api.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "fk_foodItem_id")
    private FoodItem foodItem;

    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
    private int orderQuantity;

    @Enumerated(EnumType.STRING)
    private Status status;
}
