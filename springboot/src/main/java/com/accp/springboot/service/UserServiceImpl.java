package com.accp.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.accp.springboot.dao.UserRepository;
import com.accp.springboot.entity.User;

@Repository
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Override
	public void save(User user) {
		userRepository.save(user);		
	}

	@Override
	public User findByName(String name) {
		return this.userRepository.findByName(name);
	}

}
