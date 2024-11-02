package com.e_Commerce_app_group.e_commerce_dashboard.services;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthRepo signUpRepo;

    public SignUpEntity checkUser(String email){
        try {
            return signUpRepo.findByEmail(email);
        } catch (Exception e) {
            return null;
        }

    }



}
