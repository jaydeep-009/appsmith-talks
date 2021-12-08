package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Attendee;
import com.example.demo.repository.AttendeeRepository;
import com.example.demo.service.AttendeeService;

@Service
public class AttendeeServiceImpl implements AttendeeService {

	@Autowired
	private AttendeeRepository attendeeRepository;

	@Override
	public Attendee createAttendee(Attendee attendee) {
		return attendeeRepository.save(attendee);
	}

}