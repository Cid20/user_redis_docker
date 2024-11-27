package com.example.user_redis;

import com.example.user_redis.payload.ApiResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, ApiResponse> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, ApiResponse> template = new RedisTemplate<>();
        template.setConnectionFactory(factory);

        // Serializer o'rnatish
        template.setDefaultSerializer(new JdkSerializationRedisSerializer());
        return template;
    }
}
