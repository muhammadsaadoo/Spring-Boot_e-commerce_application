package com.e_Commerce_app_group.e_commerce_dashboard.repositories;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.CategoryEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepo extends MongoRepository<CategoryEntity, ObjectId> {
    Optional<CategoryEntity> findByName(String name);
    void deleteByName(String name);
}
