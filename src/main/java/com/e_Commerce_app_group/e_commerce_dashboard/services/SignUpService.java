package com.e_Commerce_app_group.e_commerce_dashboard.services;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Random;

@Service
public class SignUpService {
@Autowired
    private AuthRepo signUpRepo;
    private static final PasswordEncoder passwordencoder=new BCryptPasswordEncoder();
    @Autowired
    private EmailService emailService;

    private int verificationCode=0;


    private SignUpEntity signUpEntity;

    private String role;

public Object insertUser(String verificationCode){
    int number = Integer.parseInt(verificationCode);

    if(number==this.verificationCode && signUpEntity !=null) {
        try {
            signUpEntity.setPassword(passwordencoder.encode(signUpEntity.getPassword()));
            signUpEntity.setRoles(List.of(role));
            SignUpEntity is_add = signUpRepo.save(signUpEntity);


            // You can add custom logic if needed
            if (is_add != null) {
                signUpEntity = null;
                role = "";
                this.verificationCode=0;
                return is_add;
            } else {
                // Handle the case where the user could not be added
                return "Failed to register user";
            }
        } catch (Exception e) {
            return null;
        }
    }
    else{
        return "wrong verification code";
    }

}



    public Object verifyEmail(SignUpEntity newUser, BindingResult result,String role) {
        // Check for validation errors
        try {
            if (result.hasErrors()) {
                // Return validation errors (you can customize this)
                return result.getFieldErrors().stream()
                        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                        .toList();
            }
            //encrypt password


            // If no validation errors, proceed with saving the user
            Random random = new Random();
           verificationCode= 1000 + random.nextInt(9000);


           if( emailService.sendEnail(newUser.getEmail(),"hi im java mail sender","Ypur verification code is "+verificationCode)){
               signUpEntity=newUser;
               this.role=role;
               return "verification code sent to your gmail";
           }
           else{
               return "enter correct gmail";
           }

        } catch (Exception e) {
            return "Error";
        }
    }



}
