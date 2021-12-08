package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface UserMapper extends HibernateAwareMapper {

	 @Mappings({
		 @Mapping(target = "id", ignore = true),
		 @Mapping(target="email", source="userDTO.email"),
		 @Mapping(target="mobileNumber", source="userDTO.mobileNumber"),
		 @Mapping(target="firstName", source="userDTO.firstName"),
		 @Mapping(target="lastName", source="userDTO.lastName"),
		 @Mapping(target="roleId", source="userDTO.roleId")
	 })
	 public User toUser(UserDTO userDTO);

}