package com.example.Restaurant_Management_Service_Api.service;

import com.example.Restaurant_Management_Service_Api.model.AuthenticationToken;
import com.example.Restaurant_Management_Service_Api.model.User;
import com.example.Restaurant_Management_Service_Api.model.dto.SignInInput;
import com.example.Restaurant_Management_Service_Api.model.dto.SignUpOutput;
import com.example.Restaurant_Management_Service_Api.model.enums.UserRole;
import com.example.Restaurant_Management_Service_Api.repository.IAuthTokenRepo;
import com.example.Restaurant_Management_Service_Api.repository.IUserRepo;
import com.example.Restaurant_Management_Service_Api.service.utility.emailUtility.EmailHandler;
import com.example.Restaurant_Management_Service_Api.service.utility.hashingUtility.PasswordEncrypter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;

    @Autowired
    IAuthTokenRepo authTokenRepo;

    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if (newEmail == null) {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus, signUpStatusMessage);
            }
        UserRole role = user.getUserRole();
        if(role == UserRole.ADMIN && !newEmail.endsWith(("@admin.com"))) {
            throw new IllegalArgumentException("Invalid email format for admin");
        }
        else if(role == UserRole.NORMAL_USER && !newEmail.endsWith(("@gmail.com"))){
            throw new IllegalArgumentException("Invalid email format for normal user");

        }


            //check if this user email already exists??
            User existingUser = userRepo.findFirstByUserEmail(newEmail);

            if (existingUser != null) {
                signUpStatusMessage = "Email already registered";
                signUpStatus = false;
                return new SignUpOutput(signUpStatus, signUpStatusMessage);
            }

            //hash the password: encrypt the password
            try {
                String encryptPassword = PasswordEncrypter.encryptPassword(user.getUserPassword());

                //saveOrder the user with the new encrypted password
                user.setUserPassword(encryptPassword);
                userRepo.save(user);

                return new SignUpOutput(signUpStatus, "User registered successfully!!!");

            } catch (Exception e) {
                signUpStatusMessage = "Internal error occurred during sign up";
                signUpStatus = false;
                return new SignUpOutput(signUpStatus, signUpStatusMessage);
            }
        }


    public String signInUser(SignInInput signInInput) {
        String signInStatusMessage = null;

        String signInEmail=signInInput.getEmail();

        if(signInEmail == null){
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;
        }

        //check if this patient email already exists ??
        User exisitingUser = userRepo.findFirstByUserEmail(signInEmail);

        if(exisitingUser == null){
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;
        }

        //match passwords :

        //hash the password: encrypt the password
        try{
            String encryptedPassword = PasswordEncrypter.encryptPassword(signInInput.getPassword());
            if(exisitingUser.getUserPassword().equals(encryptedPassword)){
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken = new AuthenticationToken(exisitingUser);
                authTokenRepo.save(authToken);

                EmailHandler.sendEmail(signInEmail,"email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }else{
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e){
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public String deleteUserById(Long userId) {
        userRepo.deleteById(userId);
        return "user deleted";
    }

}

