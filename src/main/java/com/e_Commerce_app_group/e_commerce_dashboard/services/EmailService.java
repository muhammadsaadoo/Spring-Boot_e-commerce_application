package com.e_Commerce_app_group.e_commerce_dashboard.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmailService {
//java mail sender interface use
    @Autowired
    private JavaMailSender javaMailSender;
    //

    public boolean sendEnail(String to,String subject,String body){
        try{
            SimpleMailMessage mail=new SimpleMailMessage();
            mail.setTo(to);
            mail.setSubject(subject);
            mail.setText(body);
            javaMailSender.send(mail);
            return true;


        }
        catch (Exception e) {
            log.error("exception while sending email",e);
            return false;
        }

    }
}
