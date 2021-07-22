package com.example.reqres;

import com.example.reqres.model.Resource;
import com.example.reqres.model.User;
import com.example.reqres.repository.ResourceRepository;
import com.example.reqres.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReqresApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReqresApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            repository.save(new User(1,"michael.lawson@reqres.in","Michael","Lawson","https://reqres.in/img/faces/1-image.jpg"));
            repository.save(new User(2,"lindsay.ferguson@reqres.in","Lindsay","Ferguson","https://reqres.in/img/faces/2-image.jpg"));
            repository.save(new User(3,"tobias.funke@reqres.in","Tobias","Funke","https://reqres.in/img/faces/3-image.jpg"));
        };
    }
    @Bean
    CommandLineRunner initDatabase2(ResourceRepository repository) {
        return args -> {
            repository.save(new Resource(1,2000,"cerulean","#98B2D1","15-4020"));
            repository.save(new Resource(2,2001,"fuchsia rose","#C74375","17-2031"));
            repository.save(new Resource(3,2002,"true red","#BF1932","19-1664"));
        };
    }
}
