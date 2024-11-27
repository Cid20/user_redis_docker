package com.example.user_redis.service;

import com.example.user_redis.entity.User;
import com.example.user_redis.payload.ApiResponse;
import com.example.user_redis.payload.Auth;
import com.example.user_redis.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    @CachePut(value = "users", key = "#auth.username()")
    public ApiResponse save(Auth auth) {
        User user = User.builder()
                .username(auth.username())
                .password(auth.password())
                .build();

        userRepo.save(user);
        return new ApiResponse("Saved");
    }

    @Cacheable(value = "users", key = "#id")
    public ApiResponse getOne(Long id) {
        User user = userRepo.findById(id).orElse(null);
        return new ApiResponse(user);
    }
}
