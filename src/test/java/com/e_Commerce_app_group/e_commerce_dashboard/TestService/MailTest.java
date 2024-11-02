package com.e_Commerce_app_group.e_commerce_dashboard.TestService;

import com.e_Commerce_app_group.e_commerce_dashboard.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailTest {
    @Autowired
    private EmailService emailService;
    @Test
    public void sendEmail(){
        emailService.sendEnail("muhammadsaadoo305@gmail.com","hi im java mail sender","how are you");
    }
}
