package com.e_Commerce_app_group.e_commerce_dashboard.services;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.ProductEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.AuthRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddToCartService {

    @Autowired
    private ProductService productService;
    @Autowired
    private AdminUserService adminUserService;
    @Autowired
    private AuthRepo authRepo;

    public SignUpEntity addtocart(String productName, String email) {


            Optional<ProductEntity> product = productService.getProductByName(productName);
//            SignUpEntity user = adminUserService.findUserByEmail(email);
            if (product != null && product.isPresent()) {
                SignUpEntity user = adminUserService.findUserByEmail(email);
                ProductEntity oldentry = product.get();


                    List<ObjectId> cartlist = user.getAddToCart();
                    cartlist.add(oldentry.getId());

                    return authRepo.save(user);


            }
            return null;




    }
}

