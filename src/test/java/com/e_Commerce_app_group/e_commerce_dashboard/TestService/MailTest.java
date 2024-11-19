package com.e_Commerce_app_group.e_commerce_dashboard.TestService;

import com.e_Commerce_app_group.e_commerce_dashboard.services.EmailService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class MailTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private EmailService emailService;
    @Disabled
    @Test
    public void sendEmail(){
        emailService.sendEnail("muhammadsaadoo305@gmail.com","hi im java mail sender","how are you");
    }



    @Test
    void testRedis() {
//        redisTemplate.opsForValue().set("uni","numl");
        Object name=redisTemplate.opsForValue().get("age");

    }
}
