package com.spring.Redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/url")
@RestController
public class RedisController {

	 @Autowired
	 StringRedisTemplate redisTemplate;
	 

	    @GetMapping("/{id}")
	    public String getUrl(@PathVariable String id) {

	        String url = redisTemplate.opsForValue().get(id);
	        System.out.println("URL Retrieved: " + url);

	        if (url == null) {
	            throw new RuntimeException("There is no shorter URL for : " + id);
	        }
	        return url;
	    }
	    
}
