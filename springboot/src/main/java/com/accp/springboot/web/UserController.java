package com.accp.springboot.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accp.springboot.entity.User;
import com.accp.springboot.service.UserService;

@RestController
public class UserController {
   
	@Autowired
	private UserService userService;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@GetMapping("/saveUser")
	public User saveUser(User user){
		mongoTemplate.save(user);
		return user;
	}
	@GetMapping("/findUser")
	public List<User> findUser(){
		List<User> userList=mongoTemplate.findAll(User.class);
		return userList;
	}
	public User findByUser(@RequestParam("name") String name){
		User user=userService.findByName(name);
		return user;
	}
	
}
