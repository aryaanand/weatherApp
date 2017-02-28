package com.weather.api;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.weather.api.entity.Weather;

@Configuration
public class JPAConfig {
	
    @Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
    	MongoCredential credential = MongoCredential.createCredential("myuser", "weatherdata", "MyPassword".toCharArray());
        ServerAddress serverAddress = new ServerAddress("ds161099.mlab.com", 61099);

        // Mongo Client
        MongoClient mongoClient = new MongoClient(serverAddress,Arrays.asList(credential)); 

        // Mongo DB Factory
        SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(
                mongoClient, "weatherdata");

        return simpleMongoDbFactory;

    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
        if(mongoTemplate.collectionExists(Weather.class));
        mongoTemplate.dropCollection(Weather.class);
        return mongoTemplate;
    }
}

