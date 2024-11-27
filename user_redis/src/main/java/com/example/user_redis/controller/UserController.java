package com.example.user_redis.controller;

import com.example.user_redis.payload.ApiResponse;
import com.example.user_redis.payload.Auth;
import com.example.user_redis.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@RequestBody Auth auth){
        ApiResponse response = userService.save(auth);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse> getOne(@PathVariable Long id){
        ApiResponse response = userService.getOne(id);
        return ResponseEntity.ok(response);
    }
}
