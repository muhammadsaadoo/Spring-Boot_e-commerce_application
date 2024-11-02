package com.e_Commerce_app_group.e_commerce_dashboard.controllers;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.services.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/user")
@RestController
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;
    @GetMapping
    public Object getAlUser() {
        List<SignUpEntity> entries = adminUserService.getAllUsers();
        if ( entries !=null && !entries.isEmpty() ) {
            return entries;
        } else {
            return "no user found";
        }
    }
    @GetMapping("/{email}")
    public Object getUserByEmail(@PathVariable String email) {
        SignUpEntity user = adminUserService.findUserByEmail(email);
        if ( user !=null) {
            return user;
        } else {
            return "no user found of email :"+email;
        }
    }

    @DeleteMapping("/{email}")
    public Object deleteUser(@PathVariable String email) {

        SignUpEntity  user = adminUserService.findUserByEmail(email);

        if (user!= null) {
            adminUserService.deleteUser(user);
            return " user deleted with email : "+user.getEmail();

        }
        return "no user found";
    }

    @GetMapping("/cartUsers")
    public List<String> getAllusersofcart() {
        return adminUserService.usersWhoCartProducts();

    }



}
