package com.example.userManagementSystem.UserManagement.service;

import com.example.userManagementSystem.UserManagement.model.User;
import com.example.userManagementSystem.UserManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.getAllUsers();
    }

    public String addUsers(List<User> users){
        List<User> originalList=getAllUsers();
        originalList.addAll(users);
        return "New Users Added";
    }

    public String addUser(User user){
        List<User> originalList =getAllUsers();
        originalList.add(user);
        return "New user added";
    }

    public User getUserById(Integer userId){
        for(User user : userRepo.getAllUsers()){
            if(user.getUserId().equals(userId)){
                return user;
            }
        }
        throw new IllegalStateException(("id not found"));
    }

    public String updateUserInfo(Integer userId, String userName, LocalDate userDOB,String userEmail,String userPhoneNumber,LocalDate userDate,LocalTime userTime){
        for(User user : userRepo.getAllUsers()){
            if(user.getUserId().equals(userId)){
                user.setUserName(userName);
                user.setUserDOB(userDOB);
                user.setUserEmail(userEmail);
                user.setUserPhoneNumber(userPhoneNumber);
                user.setUserDate(userDate);
                user.setUserTime(userTime);
                return "User updated for User id "+userId;
            }
        }
        return "User not found for userId "+userId;
    }

    public String removeInfo(Integer userId){
        List<User> originalList= getAllUsers();
        for(User u : originalList){
            if(userId.equals(u.getUserId())){
                originalList.remove(u);
                return "removed";
            }
        }
        return "Id not found";
    }




}
