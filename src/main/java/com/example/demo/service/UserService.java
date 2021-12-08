package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {

	public User createUser(User user);

	public User get(Long id); 

}