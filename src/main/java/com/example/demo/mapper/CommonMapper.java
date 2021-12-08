package com.example.demo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Talks;
import com.example.demo.model.User;
import com.example.demo.service.TalksService;
import com.example.demo.service.UserService;

@Component
public class CommonMapper {

	@Autowired
	UserService userService;

	@Autowired
	TalksService talksService;

	public User fromUserId(Long id) {
		return userService.get(id);
	}

	public Talks fromTalksId(Long id) {
		return talksService.get(id);
	}

}