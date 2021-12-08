package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Base {

	@Column(name = "created_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date createDate;

	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonIgnore
	private Date updatedDate;

}