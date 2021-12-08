package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TalksDTO;
import com.example.demo.dto.TalksSearchDTO;
import com.example.demo.mapper.TalksMapper;
import com.example.demo.model.Talks;
import com.example.demo.service.TalksService;
import com.example.demo.util.Constants;

import io.swagger.v3.oas.annotations.Operation;

@RequestMapping("/talks-api")
@RestController
public class TalksController {

	@Autowired
	private TalksService talksService;

	@Autowired
	private TalksMapper talksMapper;

	@PostMapping(value = "/talks", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = Constants.TALKS_SUMMARY, description = Constants.TALKS_CREATE_DESCRIPTION, tags = { Constants.TALKS_TAGS })
	public ResponseEntity<Talks> createTalks(@Valid @RequestBody TalksDTO talksDTO) {
		return new ResponseEntity<>(talksService.createTalks(talksMapper.toTalks(talksDTO)), HttpStatus.CREATED);
	}	

	@PostMapping(value = "/retrieve-talks", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = Constants.TALKS_RETRIEVE_SUMMARY, description = Constants.TALKS_RETRIEVE_DESCRIPTION, tags = { Constants.TALKS_TAGS })
	public List<Talks> retreiveTalks(@RequestBody TalksSearchDTO talks) {
		return  talksService.retreiveTalks(talks);
	}

}