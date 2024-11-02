package com.e_Commerce_app_group.e_commerce_dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
// PlatformTransactionManager Interface  do all the transaction functions
//MongoTransactionManager is the implementatoon of  PlatformTransactionManager
public class ECommerceDashboardApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context=SpringApplication.run(ECommerceDashboardApplication.class, args);
		ConfigurableEnvironment environment=context.getEnvironment();
		System.out.println(Arrays.toString(environment.getActiveProfiles()));
	}


}
//sonar cloud key  muhammadsaadoo