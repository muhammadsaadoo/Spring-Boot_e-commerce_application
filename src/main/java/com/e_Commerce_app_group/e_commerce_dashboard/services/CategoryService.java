package com.e_Commerce_app_group.e_commerce_dashboard.services;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.CategoryEntity;
import com.e_Commerce_app_group.e_commerce_dashboard.repositories.CategoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j  //lambok

public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;


    //logging slf4j(Simple Logging Facade for Java) it is abstraction layer of logging framework
//   private static final  Logger logger= LoggerFactory.getLogger(CategoryService.class);
    //use @slf4j annotaion

    public List<CategoryEntity> getAllcategories(){
        return categoryRepo.findAll();

    }
    public Optional<CategoryEntity> getcategoriesByName(String name){
        try {
            return categoryRepo.findByName(name);
        } catch (Exception e) {

            System.out.println("error in finding the category by name");
            throw new RuntimeException(e);
        }

    }
    public CategoryEntity addCategory(CategoryEntity entry){
        try {


            return categoryRepo.save(entry);
        } catch (Exception e) {
            //bydefault enabled
            //{}place holder
            //@SLf4j instance named log
//            logger.error("error  is occurred for {}:",entry.getName());
            log.error("error  is occurred for {}:",entry.getName());
            log.info("error is calling");
            log.warn("warn is calling");


            //not enabled
            log.debug("debug is calling");
            log.trace("trace is calling");
//            throw new RuntimeException(e);
        }
        return null;

    }
    public void deleteCategory(String name){
        categoryRepo.deleteByName(name);


    }

//    public CategoryEntry updateCategory(CategoryEntry entry){
//        return categoryRepo.save(entry);
//
//    }


}
