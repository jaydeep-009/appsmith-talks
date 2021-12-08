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

import com.example.demo.dto.AttendeeDTO;
import com.example.demo.mapper.AttendeeMapper;
import com.example.demo.model.Attendee;
import com.example.demo.service.AttendeeService;
import com.example.demo.util.Constants;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/attendee-api")
@RestController
public class AttendeeController {

	@Autowired
	private AttendeeService attendeeService;

	@Autowired
	private AttendeeMapper attendeeMapper;

	@PostMapping(value = "/attendee", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = Constants.ATTENDEE_SUMMARY, description = Constants.ATTENDEE_CREATE_DESCRIPTION, tags = { Constants.ATTENDEE_TAGS })

	public ResponseEntity<Attendee> createTalks(@Valid @RequestBody AttendeeDTO attendeeDTO) {
		return new ResponseEntity<>(attendeeService.createAttendee(attendeeMapper.toTalks(attendeeDTO)), HttpStatus.CREATED);
	}

}