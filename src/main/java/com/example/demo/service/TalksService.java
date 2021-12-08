package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.TalksSearchDTO;
import com.example.demo.model.Talks;

public interface TalksService {

	public Talks createTalks(Talks talks);

	public List<Talks> retreiveTalks(TalksSearchDTO talks);

	public Talks get(Long id);

}