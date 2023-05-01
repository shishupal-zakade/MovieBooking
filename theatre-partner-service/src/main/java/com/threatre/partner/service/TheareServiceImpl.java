package com.threatre.partner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threatre.partner.entity.Threatre;
import com.threatre.partner.repository.ThreatreRepository;

@Service
public class TheareServiceImpl implements ThreatreService {

	@Autowired
	private ThreatreRepository threatreRepository;

	@Override
	public Threatre create(Threatre threatre) {
		return threatreRepository.save(threatre);
	}

	@Override
	public List<Threatre> findByCity(String city) {
		// TODO Auto-generated method stub
		return threatreRepository.findByCity(city);
	}

	@Override
	public List<Threatre> findByCityAndTheatreIds(String city, List<Integer> id) {
		return threatreRepository.findByCityAndIdIn(city, id);
	}

}
