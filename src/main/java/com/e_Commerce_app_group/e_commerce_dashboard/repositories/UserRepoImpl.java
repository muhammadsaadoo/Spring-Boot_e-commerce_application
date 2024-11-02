package com.e_Commerce_app_group.e_commerce_dashboard.repositories;

import com.e_Commerce_app_group.e_commerce_dashboard.Pojos.SignUpEntity;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//for learn  criteria
//custom quries
@Repository
public class UserRepoImpl {

    @Autowired
    private MongoTemplate mongoTemplate;
    //mongo template a class spring data mongodb is priovide us
    //
    //create a method that get the users they cart products
    public List<String> usersWhoCartProducts(){
        Query query=new Query();
        ObjectId objectId = new ObjectId("6703e7125441f27ae55d8a6c");
        query.addCriteria(Criteria.where("addToCart").is(objectId));
        return mongoTemplate.find(query, SignUpEntity.class).stream()
                .map(SignUpEntity::getEmail)
                .toList();

    }
}
