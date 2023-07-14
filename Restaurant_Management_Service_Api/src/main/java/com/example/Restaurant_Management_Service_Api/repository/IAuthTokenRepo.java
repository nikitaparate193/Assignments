package com.example.Restaurant_Management_Service_Api.repository;

import com.example.Restaurant_Management_Service_Api.model.AuthenticationToken;
import com.example.Restaurant_Management_Service_Api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthTokenRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);

}
