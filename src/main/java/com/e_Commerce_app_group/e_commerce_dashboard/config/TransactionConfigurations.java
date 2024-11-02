package com.e_Commerce_app_group.e_commerce_dashboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class TransactionConfigurations {
    //create a bean to tell the PlatformTransactionManager about MongoTransactionManager
    @Bean
    public PlatformTransactionManager add(MongoDatabaseFactory dbFactory){ //MongoDatabaseFactory is interface
        //so where is its implementation?
        //so spring created its implementation class by itself called SimpleMongoClientDatabaseeFactory
        return new MongoTransactionManager(dbFactory);
    }
}
