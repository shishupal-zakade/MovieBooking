package com.threatre.partner.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.threatre.partner.entity.Threatre;

@Service
public interface ThreatreService {

	Object create(Threatre threatre);

	List<Threatre> findByCity(String city);

	List<Threatre> findByCityAndTheatreIds(String city, List<Integer> id);

}
