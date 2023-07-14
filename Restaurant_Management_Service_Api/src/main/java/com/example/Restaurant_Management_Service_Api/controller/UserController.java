package com.example.Restaurant_Management_Service_Api.controller;

import com.example.Restaurant_Management_Service_Api.model.dto.SignInInput;
import com.example.Restaurant_Management_Service_Api.model.dto.SignUpOutput;
import com.example.Restaurant_Management_Service_Api.model.User;
import com.example.Restaurant_Management_Service_Api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user){

        return userService.signUpUser(user);
    }

    @PostMapping("user/signIn")
    public String signInUser(@RequestBody @Valid SignInInput signInInput){
        return userService.signInUser(signInInput);
    }

    @GetMapping("users")
    List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("user/{userId}")
    public void deleteUserById(@PathVariable Long userId){

        userService.deleteUserById(userId);
    }


}
