package com.example.Restaurant_Management_Service_Api.model;

import com.example.Restaurant_Management_Service_Api.model.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String userPassword;
    @Email
    private String userEmail;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
}
