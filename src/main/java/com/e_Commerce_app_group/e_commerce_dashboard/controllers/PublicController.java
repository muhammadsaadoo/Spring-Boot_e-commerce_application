package com.e_Commerce_app_group.e_commerce_dashboard.controllers;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.CategoryEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.ProductEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.services.CategoryService;
import com.e_Commerce_app_group.e_commerce_dashboard.services.ProductService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired

    @GetMapping("/categories/getAll")
    public Object getAlCategories() {
        List<CategoryEntity> entries = categoryService.getAllcategories();
        if ( entries !=null && !entries.isEmpty() ) {
            return entries;
        } else {
            return "no categories found";
        }
    }

    @GetMapping("/products/getProductsByCategoryName/{categoryName}")
    public Object allproductsofCategory(@PathVariable String categoryName) {
        Optional<CategoryEntity> category = categoryService.getcategoriesByName(categoryName.toLowerCase(Locale.ROOT).trim());
        if (category.isPresent()) {
            CategoryEntity getcategories = category.get();
            List<ObjectId> productIds = getcategories.getListOfProductsIds();
            if (getcategories.getListOfProductsIds().isEmpty()) {
                return "no Products Found";
            }
            return productService.getProductsByIds(productIds);

        }
        return "no category found";
    }

    @GetMapping("products/getAll")
    public Object getpAllProduct() {

        List<ProductEntity> products = productService.getAllProducts();

        if (products != null && !products.isEmpty()) {
            return products;
        }
        return "no product found";
    }

    @GetMapping("/products/getProductByName/{name}")
    public Object getProductByName(@PathVariable String name) {

        Optional<ProductEntity> products = productService.getProductByName(name);

        if (products != null && products.isPresent()) {
            return products;
        }
        return "no product found";
    }

}
