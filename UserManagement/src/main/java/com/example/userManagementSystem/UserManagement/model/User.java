package com.example.userManagementSystem.UserManagement.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @NotNull
    private Integer userId;

    @NotBlank(message = "name cannot be blank")
    private String userName;

    @NotNull
    private LocalDate userDOB;

    @Email(message="Given email id is invalid ")
    private String userEmail;

    @Size(min=10, max=12)
    @Pattern(regexp="^(\\d{2})\\d{10}$")
    private String userPhoneNumber;

    private LocalDate userDate;


    private LocalTime userTime;
}
