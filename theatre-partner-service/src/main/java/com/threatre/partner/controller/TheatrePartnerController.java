package com.threatre.partner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threatre.partner.entity.Threatre;
import com.threatre.partner.service.ThreatreService;

@RestController
@RequestMapping("/theatre/partner")
public class TheatrePartnerController {

	@Autowired
	ThreatreService threatreService;

	@PostMapping("/create")
	public ResponseEntity<?> createTheatre(@RequestBody Threatre threatre) {
		return ResponseEntity.status(HttpStatus.OK).body(threatreService.create(threatre));
	}

	@GetMapping("/getByCity/{city}")
	public List<Threatre> getByCity(@PathVariable String city) {
		System.out.println("threatreRepository.findByCity(city)"+threatreService.findByCity(city).size());
		return threatreService.findByCity(city);
	}
	
	@GetMapping("/findTheatres/{city}")
	public List<Threatre> getByCityAndIds(@PathVariable String city, @RequestParam List<Integer> id) {
		System.out.println("threatreRepository.findByCity(city)"+threatreService.findByCityAndTheatreIds(city,id));
		return threatreService.findByCityAndTheatreIds(city,id);
	}
}
