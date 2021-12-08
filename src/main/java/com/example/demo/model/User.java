package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import com.example.demo.util.Constants;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends Base {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;

	@Column(name="email", columnDefinition = "VARCHAR(80)", unique=true)
	@JsonProperty(value = "email")
	private String email;

	@Size(max = 10, min = 10, message = Constants.USER_DTO_MOBILE_NUMBER_MESSAGE)
	@Column(name="mobile_number", columnDefinition = "VARCHAR(10)", unique=true)
	private String mobileNumber;

	@Column(name="first_name", columnDefinition = "varchar(100)")
	private String firstName;

	@Column(name="last_name", columnDefinition = "varchar(100)")
	private String lastName;

	@Column(name="role_id")
	private Integer roleId;

}