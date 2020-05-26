package com.spring.Redis.repository.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import com.spring.Redis.entity.User;

public class UserRepositoryService {

	
	private RedisTemplate<String, User> redisTemplate;

    private HashOperations hashOperations;

    public UserRepositoryService(RedisTemplate<String, User> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }
}
