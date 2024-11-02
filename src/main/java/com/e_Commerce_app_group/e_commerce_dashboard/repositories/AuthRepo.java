package com.e_Commerce_app_group.e_commerce_dashboard.repositories;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuthRepo extends MongoRepository<SignUpEntity, ObjectId> {
    SignUpEntity findByEmail(String email);


}
