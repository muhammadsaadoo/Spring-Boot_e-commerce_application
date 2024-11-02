package com.e_Commerce_app_group.e_commerce_dashboard.TestService;

import com.e_Commerce_app_group.e_commerce_dashboard.repositories.UserRepoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserrepoimplTest {
    @Autowired
    private UserRepoImpl userRepo;
    @Test
    public void testaddtocrat(){
        userRepo.usersWhoCartProducts();

    }

}
