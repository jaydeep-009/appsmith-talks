package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TalksSearchDTO;
import com.example.demo.model.Talks;
import com.example.demo.repository.TalksRepository;
import com.example.demo.service.TalksService;

@Service
public class TalksServiceImpl implements TalksService {

	@Autowired
	private TalksRepository talksRepository;

	@Override
	public Talks createTalks(Talks talks) {
		return talksRepository.save(talks);
	}

	@Override
	public List<Talks> retreiveTalks(TalksSearchDTO talks) {
		Specification<Talks> talksSpecification = talksRepository.getTalksSearchSpecification(talks);
		return talksRepository.findTalksForSearch(talksSpecification);
	}

	@Override
	public Talks get(Long id) {
		return talksRepository.findById(id).orElse(null);
	}

}	