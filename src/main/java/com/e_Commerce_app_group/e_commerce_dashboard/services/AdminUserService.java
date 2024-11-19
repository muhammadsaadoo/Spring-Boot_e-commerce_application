package com.e_Commerce_app_group.e_commerce_dashboard.services;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.AuthRepo;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.UserRepoImpl;
import com.e_Commerce_app_group.e_commerce_dashboard.services.impl.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class AdminUserService implements IAdminService {
    @Autowired
    private AuthRepo signUpRepo;
    @Autowired
    private UserRepoImpl userRepo;
    @Autowired
    private EmailService emailService;

    public List<SignUpEntity> getAllUsers(){
        return signUpRepo.findAll();

    }
    public SignUpEntity findUserByEmail(String email){
        return signUpRepo.findByEmail(email);

    }
    public void deleteUser(SignUpEntity user){
        signUpRepo.delete(user);

    }
    public List<String> usersWhoCartProducts(){
        try{
            return userRepo.usersWhoCartProducts();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
//    @Scheduled(cron = "0 0/2 * * * ?")
    public void sendEmails(){
        String subject="cart products";
        String body="you cart some produvts to buy";
      try{
        List<String> emails= usersWhoCartProducts();
        for (String email : emails) {
            try {
                emailService.sendEnail(email, subject, body);
                log.info("email  sent on : {}", email);
            } catch (Exception e) {
                log.error("emial not sent to : {}",email);
                throw new RuntimeException(e);
            }




             // Assuming sendEmailToUser is a method that sends an email
        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

}

}
