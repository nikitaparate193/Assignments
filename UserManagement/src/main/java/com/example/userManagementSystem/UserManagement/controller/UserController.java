package com.example.userManagementSystem.UserManagement.controller;

import com.example.userManagementSystem.UserManagement.model.User;
import com.example.userManagementSystem.UserManagement.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("userById/{userId}")
    public User getUserById(@PathVariable Integer userId){
        return userService.getUserById(userId);
    }
    @PostMapping("users")
    public String addUsers(@Valid @RequestBody List<User> users){
        return userService.addUsers(users);
    }
    @PutMapping("user/{userId}/{userName}/{userDOB}/{userEmail}/{userPhoneNumber}/{userDate}/{userTime}")
    public String updateUserInfo(@PathVariable Integer userId,@PathVariable String userName,@PathVariable LocalDate userDOB,@PathVariable String userEmail,@PathVariable String userPhoneNumber,@PathVariable LocalDate userDate, @PathVariable LocalTime userTime){
        return userService.updateUserInfo(userId,userName,userDOB,userEmail,userPhoneNumber,userDate,userTime);
    }
    @DeleteMapping("user/{userId}")
    public String deleteUserInfo(@PathVariable Integer userId){
        return userService.removeInfo(userId);
    }
}
