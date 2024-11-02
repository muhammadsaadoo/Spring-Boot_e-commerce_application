package com.e_Commerce_app_group.e_commerce_dashboard.services;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssignRolesService {
    @Autowired
    private AuthRepo signUpRepo;


    public SignUpEntity assignAsAdmin(String email){
        SignUpEntity user=signUpRepo.findByEmail(email);
        if(user != null){
            List<String> updatedUser = user.getRoles();
            updatedUser.add("ADMIN");
           user.setRoles(updatedUser);
           return signUpRepo.save(user);
        }
        return null;
    }

    public SignUpEntity deAssignAdmin(String email){
        SignUpEntity user=signUpRepo.findByEmail(email);
        if(user != null){
            List<String> updatedUser = user.getRoles();
            updatedUser.remove("ADMIN");
            user.setRoles(updatedUser);
            return signUpRepo.save(user);
        }
        return null;
    }
}
