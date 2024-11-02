package com.e_Commerce_app_group.e_commerce_dashboard.controllers;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/signup")
public class AuthController {

    @Autowired
    private SignUpService signUpService;



    @PostMapping
    public Object signUp(@Valid @RequestBody SignUpEntity newUser, BindingResult result) {
        return signUpService.verifyEmail(newUser,result,"USER");

    }
    @PostMapping("/{verificationCode}")
    public Object verify(@PathVariable String verificationCode) {
        return signUpService.insertUser(verificationCode);

    }

}
