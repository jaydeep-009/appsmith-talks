package com.example.demo.dto;

import javax.validation.constraints.NotNull;

import com.example.demo.util.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendeeDTO {

	private Long id;

	@NotNull(message = Constants.ATTENDEE_DTO_TALKS_ID_MESSAGE)
	private Long talksId;

	@NotNull(message = Constants.ATTENDEE_DTO_USER_ID_MESSAGE)
	private Long userId;

}