package com.e_Commerce_app_group.e_commerce_dashboard.controllers;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.ProductEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.services.CategoryService;
import com.e_Commerce_app_group.e_commerce_dashboard.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;





    @PostMapping("/{categoryName}")
    public Object insertProduct(@PathVariable String categoryName,@RequestBody ProductEntity newentry) {
       return productService.addProductByCategory(categoryName,newentry);
    }


    @DeleteMapping("/{name}")
    public Object deleteProduct(@PathVariable String name) {

        Optional<ProductEntity> products = productService.getProductByName(name);

        if (products != null && products.isPresent()) {
            productService.deleteProduct(products.get());
            return "deleted ";
        }
        return "no product found";
    }

    @PutMapping("/{name}")
    public Object updateProduct(@PathVariable String name,@RequestBody ProductEntity updatedentry) {

        Optional<ProductEntity> products = productService.getProductByName(name);

        if (products != null && products.isPresent()) {
            ProductEntity oldentry=products.get();
            oldentry.setName(updatedentry.getName());
            oldentry.setDescription(updatedentry.getDescription());
            oldentry.setStock(updatedentry.getStock());
            oldentry.setPrice(updatedentry.getPrice());
            return productService.addProduct(oldentry);

        }
        return "no product found";
    }













}
