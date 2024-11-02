package com.e_Commerce_app_group.e_commerce_dashboard.controllers;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.services.AssignRolesService;
import com.e_Commerce_app_group.e_commerce_dashboard.services.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/assign-role")
public class AssignRolesController {
    @Autowired
    private SignUpService signUpService;
    @Autowired
    private AssignRolesService adminService;
    @PostMapping("/assign-admin-role/{email}")
    public Object assignRole(@PathVariable  String email) {
        SignUpEntity updatedUser=adminService.assignAsAdmin(email);
        if(updatedUser != null){
            return updatedUser;
        }
        return "user not found";


    }
    @PostMapping("/de-assign-admin-role/{email}")
    public Object deAssignRole(@PathVariable  String email) {
        SignUpEntity updatedUser=adminService.deAssignAdmin(email);
        if(updatedUser != null){
            return updatedUser;
        }
        return "user not found";


    }
}

