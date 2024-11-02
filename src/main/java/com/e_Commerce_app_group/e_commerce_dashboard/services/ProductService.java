package com.e_Commerce_app_group.e_commerce_dashboard.services;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.CategoryEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.ProductEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.ProductRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryService categoryService;

    public Optional<ProductEntity> getProductByName(String name){
        return productRepo.findByName(name);
    }
    public List<ProductEntity> getAllProducts(){
        return productRepo.findAll();
    }

    public ProductEntity addProduct(ProductEntity entry){
        return productRepo.save(entry);
    }
    public void deleteProduct(ProductEntity name){
         productRepo.delete(name);
    }
    @Transactional
    public Object addProductByCategory( String categoryName, ProductEntity newentry) {
        try {


            Optional<CategoryEntity> categoryOpt = categoryService.getcategoriesByName(categoryName.toLowerCase(Locale.ROOT).trim());
            if (categoryOpt.isPresent()) {
                CategoryEntity category = categoryOpt.get();
                ProductEntity newproduvtentry = productRepo.save(newentry);

                category.getListOfProductsIds().add(newproduvtentry.getId());
                category.setNo_of_products(category.getNo_of_products() + 1);
                categoryService.addCategory(category);

                return newproduvtentry;


            }
            return "no category found";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public List<ProductEntity> getProductsByIds(List<ObjectId> productIds) {
        return productRepo.findByIdIn(productIds);
    }

}
