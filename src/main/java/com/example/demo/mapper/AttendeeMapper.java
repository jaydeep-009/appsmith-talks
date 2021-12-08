package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import com.example.demo.dto.AttendeeDTO;
import com.example.demo.model.Attendee;

@Mapper(uses = CommonMapper.class, componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface AttendeeMapper extends HibernateAwareMapper {

	 @Mappings({
		 @Mapping(target = "id", ignore = true),
		 @Mapping(target="talks", source="attendeeDTO.talksId"),
		 @Mapping(target="user", source="attendeeDTO.userId"),
	 })
	 public Attendee toTalks(AttendeeDTO attendeeDTO);

}