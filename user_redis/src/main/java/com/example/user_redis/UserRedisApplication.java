package com.example.user_redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UserRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserRedisApplication.class, args);
    }

}
