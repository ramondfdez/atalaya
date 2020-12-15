package com.example.HolaAtalaya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;


@SpringBootApplication
@RestController
public class HolaAtalayaApplication {
  
    
    public static void main(String[] args) {
    	
    	MongoClientURI uri = new MongoClientURI("mongodb+srv://atalaya:prueba_00@cluster0.j5twp.mongodb.net/sample_mflix?retryWrites=true&w=majority");

    	MongoClient mongoClient = new MongoClient(uri);
    	MongoDatabase database = mongoClient.getDatabase("sample_mflix");
    	
    	System.out.println("nombre: " + database.getName());
    	
    	SpringApplication.run(HolaAtalayaApplication.class, args);
    
    
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
    }
  
}
