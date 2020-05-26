package com.spring.Redis.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.Redis.entity.User;
import com.spring.Redis.repository.UserRepository;

@RequestMapping("/rest/url")
@RestController
public class RedisController {

	   private UserRepository userRepository;

	    public RedisController(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }

	    @GetMapping("/add/{id}/{name}")
	    public User add(@PathVariable("id") final String id,
	                    @PathVariable("name") final String name) {
	        userRepository.save(new User(id, name, 20000L));
	        return userRepository.findById(id);
	    }

	    @GetMapping("/update/{id}/{name}")
	    public User update(@PathVariable("id") final String id,
	                       @PathVariable("name") final String name) {
	        userRepository.update(new User(id, name, 1000L));
	        return userRepository.findById(id);
	    }

	    @GetMapping("/delete/{id}")
	    public Map<String, User> delete(@PathVariable("id") final String id) {
	        userRepository.delete(id);
	        return all();
	    }
	    
	    @GetMapping("/find/{id}")
	    public User find(@PathVariable("id") final String id) {
	    	return userRepository.findById(id);
	        
	    }

	    @GetMapping("/all")
	    public Map<String, User> all() {
	        return userRepository.findAll();
	    }
	    
}
