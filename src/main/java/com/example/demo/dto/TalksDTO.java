package com.example.demo.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.example.demo.util.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TalksDTO {

	private Long id;

	@NotNull(message = Constants.TALKS_DTO_TITLE_MESSAGE)
	private String title;

	@NotNull(message = Constants.TALKS_DTO_DESCRIPTION_MESSAGE)
	private String description;

	@NotNull(message = Constants.TALKS_DTO_START_DATE_MESSAGE)
	private Date startDate;

	@NotNull(message = Constants.TALKS_DTO_END_DATE_MESSAGE)
	private Date endDate;

	@NotNull(message = Constants.TALKS_DTO_SPEAKER_ID_MESSAGE)
	private Long speakerId;

}