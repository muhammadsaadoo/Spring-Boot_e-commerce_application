//package com.e_Commerce_app_group.e_commerce_dashboard.TestService;
//
//import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
//import com.e_Commerce_app_group.e_commerce_dashboard.Repositories.SignUpRepo;
//import com.e_Commerce_app_group.e_commerce_dashboard.Services.UserDetailServiceImpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//
//import static org.mockito.Mockito.when;
//@SpringBootTest
//public class UserDetailServiceMockTest {
////   @Autowired
//    @InjectMocks
//   private UserDetailServiceImpl userDetailService;
////   @MockBean
//    @Mock
//   private SignUpRepo signUpRepo;
//    @BeforeEach
//    void setUpMocks(){
//        MockitoAnnotations.openMocks(this);
//
//    }
//    @Test
//    void loadUserByUsernameTest(){
//        SignUpEntity mockSignUpEntity = new SignUpEntity();
//        mockSignUpEntity.setEmail("user3@gmail.com");
//        mockSignUpEntity.setPassword("koch b ho sakta ha");
//        mockSignUpEntity.setRoles(new ArrayList<>());
//        when(signUpRepo.findByEmail(ArgumentMatchers.anyString())).thenReturn(mockSignUpEntity);
//        UserDetails user=userDetailService.loadUserByUsername("user3@gmail.com");
////        Assertions.assertNotNull(user);
//    }
//}
