package com.example.demo.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TalksSearchDTO {

	private Integer speaker;

	private String queryParam;

	private Date startDate;

	private Date endDate;

}