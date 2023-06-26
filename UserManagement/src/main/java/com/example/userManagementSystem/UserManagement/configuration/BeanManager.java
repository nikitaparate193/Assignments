package com.example.userManagementSystem.UserManagement.configuration;

import com.example.userManagementSystem.UserManagement.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanManager {
    @Bean
    public List<User> getInitializedList(){
        User initUser = new User(1,"Nikita", LocalDate.of(1998,03,19),"niksparate2@gmail.com","912223334445",LocalDate.of(2023,06,26), LocalTime.of(6,0,0));
            List<User> initList=new ArrayList<>();
            initList.add(initUser);

        return initList;
    }
}
