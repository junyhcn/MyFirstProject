package com.accp.springboot.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.accp.springboot.entity.User;

public interface UserRepository extends MongoRepository<User,Integer>{
   public User findByName(String name);
}
