package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import com.example.demo.dto.TalksDTO;
import com.example.demo.model.Talks;

@Mapper(uses = CommonMapper.class, componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface TalksMapper extends HibernateAwareMapper {

	 @Mappings({
		 @Mapping(target = "id", ignore = true),
		 @Mapping(target="title", source="talksDTO.title"),
		 @Mapping(target="description", source="talksDTO.description"),
		 @Mapping(target="startDate", source="talksDTO.startDate"),
		 @Mapping(target="endDate", source="talksDTO.endDate"),
		 @Mapping(target="speaker", source="talksDTO.speakerId")
	 })
	 public Talks toTalks(TalksDTO talksDTO);

}