package com.e_Commerce_app_group.e_commerce_dashboard.controllers;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.CategoryEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;



    @PostMapping
    public Object addCategories(@RequestBody CategoryEntity newentry) {

        newentry.setName(newentry.getName().toLowerCase(Locale.ROOT).trim());
        CategoryEntity entries = categoryService.addCategory(newentry);
        if (entries != null) {
            return entries;
        } else {
            return "error";
        }


    }

    @PutMapping("/{name}")
    public Object updateCategories(@RequestBody CategoryEntity newentry, @PathVariable String name) {
        Optional<CategoryEntity> optionalEntry = categoryService.getcategoriesByName(name.toLowerCase(Locale.ROOT).trim());
        if (optionalEntry.isPresent()) {
            CategoryEntity entry=optionalEntry.get();
            entry.setName(newentry.getName());
            entry.setDescription(newentry.getDescription());
            entry.setNo_of_products(newentry.getNo_of_products());
            return categoryService.addCategory(entry);

        } else {
            return "not found";
        }


    }

    @DeleteMapping("/{name}")
    public Object deleteCategories(@PathVariable String name) {
        Optional<CategoryEntity> optionalEntry = categoryService.getcategoriesByName(name.toLowerCase(Locale.ROOT).trim());
        if (optionalEntry.isPresent()) {
            categoryService.deleteCategory(name.toLowerCase(Locale.ROOT).trim());
            return "deleted";


        } else {
            return "not found";
        }


    }



}
