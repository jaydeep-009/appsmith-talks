package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.util.Constants;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/users-api")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = Constants.USER_SUMMARY, 
		description = Constants.USER_CREATE_DESCRIPTION, 
		tags = { Constants.USER_TAGS })
	public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO user) {
		return new ResponseEntity<>(userService.createUser(userMapper.toUser(user)), HttpStatus.CREATED);
	}

}