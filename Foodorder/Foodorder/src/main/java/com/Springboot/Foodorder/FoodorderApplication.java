package com.Springboot.Foodorder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.Springboot.Foodorder.repository")
public class FoodorderApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodorderApplication.class, args);
    }
}