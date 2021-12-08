package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRegistractionRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRegistractionRepository userRegistractionRepository;

	@Override
	public User createUser(User user) {
		return userRegistractionRepository.save(user);
	}

	@Override
	public User get(Long id) {
		return userRegistractionRepository.findById(id).orElse(null);
	}

}