package com.threatre.booking.controller;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.threatre.booking.entity.Booking;
import com.threatre.booking.service.BookingService;

@RestController
@RequestMapping("/theatre/booking")
public class TheatreBookingController {

	@Autowired
	BookingService bookingService;

	@PostMapping(value = "/book", consumes = { "application/json" })
	public ResponseEntity<?> createBooking(@RequestBody Booking booking) {
		return ResponseEntity.status(HttpStatus.OK).body(bookingService.createBooking(booking));
	}
//
//	@PostMapping(value = "/update", consumes = { "application/json" })
//	public ResponseEntity<?> updateShow(@RequestBody Booking show) {
//		return ResponseEntity.status(HttpStatus.OK).body(bookingRepository.save(show));
//	}
//
//	@DeleteMapping(value = "/delete/{id}")
//	public ResponseEntity<?> deleteShow(@PathVariable Integer id) {
//		bookingRepository.deleteById(id);
//		return ResponseEntity.status(HttpStatus.OK).body(null);
//	}
//
	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings() {
		return bookingService.getAllBooking();
	}
//
//	@GetMapping("/getAll")
//	public List<Booking> test() {
//		System.out.println("LocalTime.now() -" + LocalTime.now());
//		System.out.println("LocalTime.now() -" + Timestamp.from(ZonedDateTime.now().toInstant()));
//		return bookingRepository.findAll();
//	}
//	
}
