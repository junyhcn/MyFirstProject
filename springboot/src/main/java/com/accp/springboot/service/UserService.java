package com.accp.springboot.service;

import org.springframework.stereotype.Repository;

import com.accp.springboot.entity.User;

@Repository
public interface UserService {
	public void save(User user);
	public User findByName(String name);
}
