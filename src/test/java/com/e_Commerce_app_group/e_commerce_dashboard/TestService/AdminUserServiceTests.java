//package com.e_Commerce_app_group.e_commerce_dashboard.TestService;
//
//import com.e_Commerce_app_group.e_commerce_dashboard.Repositories.SignUpRepo;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvSource;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//@SpringBootTest
//public class AdminUserServiceTests {
//    @Autowired
//    private SignUpRepo signUpRepo;
//
//
//    @ParameterizedTest
//    @ValueSource(strings={
//            "user2@gmail.com",
//            "user3@gmail.com",
//            "user4@gmail.com",
//
//
//    })
//
//    public void testFindUserByEmail(String email){
//        assertNotNull(signUpRepo.findByEmail(email));
////        assertEquals(4,2+2);
//    }
//
//
//    @ParameterizedTest
//    @CsvSource({
//            "1,1,2",
//            "2,2,4",
//            "3,3,9"
//    })
//    public void testadd(int a,int b,int expected){
////        assertNotNull(signUpRepo.findByEmail("user3@gmail.com"));
////        assertEquals(expected,a+b);
//    }
//}
//
////@AfterAll
////@AfterEach
////@BeforeAll
////@BeforeEach
