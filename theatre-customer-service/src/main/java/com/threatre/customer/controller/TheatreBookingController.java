package com.threatre.customer.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threatre.customer.service.CustomerService;

@RestController
@RequestMapping("/theatre/customer")
public class TheatreBookingController {

	@Autowired
	CustomerService customerService;

	@GetMapping(value = "/getTheatres")
	public ResponseEntity<?> getTheatresByMovieIdCity(@RequestParam String movieId, @RequestParam String city,
			@RequestParam String date) {

		Timestamp ts = Timestamp.valueOf(LocalDateTime.parse(date));
		return ResponseEntity.status(HttpStatus.OK)
				.body(customerService.getTheatreByCityAndMovieAndDate(movieId, city, ts));
	}

}
