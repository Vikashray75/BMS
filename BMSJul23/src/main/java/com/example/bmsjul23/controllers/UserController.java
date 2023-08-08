package com.example.bmsjul23.controllers;

import com.example.bmsjul23.dtos.SignupUserRequestDTO;
import com.example.bmsjul23.dtos.SignupUserResponseDTO;
import com.example.bmsjul23.models.User;
import com.example.bmsjul23.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public SignupUserResponseDTO signupUser(SignupUserRequestDTO requestDO){
        User user = userService.signupUser(requestDO.getName(), requestDO.getEmail(), requestDO.getEmail());
        return SignupUserResponseDTO.getSuccess(user);
    }
}
