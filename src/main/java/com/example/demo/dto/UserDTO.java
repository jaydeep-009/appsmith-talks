package com.example.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.util.Constants;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

	private Long id;

	@Email(message = Constants.USER_DTO_EMAIL_ADDRESS_MESSAGE)
	private String email;

	@Size(max = 10, min = 10, message = Constants.USER_DTO_MOBILE_NUMBER_MESSAGE)
	private String mobileNumber;

	@NotEmpty(message = Constants.USER_DTO_FIRST_NAME_MESSAGE)
	private String firstName;

	@NotEmpty(message = Constants.USER_DTO_LAST_NAME_MESSAGE)
	private String lastName;

	@NotNull(message = Constants.USER_DTO_ROLE_MESSAGE)
	private Integer roleId;

}