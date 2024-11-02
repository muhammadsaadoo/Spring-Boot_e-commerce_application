package com.e_Commerce_app_group.e_commerce_dashboard.repositories;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.ProductEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends MongoRepository<ProductEntity, ObjectId> {
    Optional<ProductEntity> findByName(String name);
    List<ProductEntity> findByIdIn(List<ObjectId> ids);

}
