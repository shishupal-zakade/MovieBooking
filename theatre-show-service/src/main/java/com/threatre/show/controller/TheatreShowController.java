package com.threatre.show.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.threatre.show.entity.Show;
import com.threatre.show.service.ShowService;

@RestController
@RequestMapping("/theatre/show")
public class TheatreShowController {

	@Autowired
	ShowService showService;

	@PostMapping(value = "/create", consumes = { "application/json" })
	public ResponseEntity<?> createShow(@RequestBody Show show) {
		return ResponseEntity.status(HttpStatus.OK).body(showService.createShow(show));
	}

	@PostMapping(value = "/update", consumes = { "application/json" })
	public ResponseEntity<?> updateShow(@RequestBody Show show) {
		return ResponseEntity.status(HttpStatus.OK).body(showService.updateShow(show));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteShow(@PathVariable Integer id) {
		showService.deleteShow(id);
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

	@GetMapping("/getRunningShow")
	public List<Show> getRunningShow() {
		return showService.findByShowStartTimeLessThanAndShowEndtimeGreaterThan(
				Timestamp.from(ZonedDateTime.now().toInstant()), Timestamp.from(ZonedDateTime.now().toInstant()));
	}
	
	@GetMapping("/getRunningShowWithMovieIdAndTime")
	public List<Show> getRunningShow(@RequestParam String movieId, @RequestParam String date) {
		Timestamp ts=null;
		if(date.contains(" ")) {
			ts =Timestamp.valueOf(date);
		}else {
			ts = Timestamp.valueOf(LocalDateTime.parse(date));
		}
		return showService.findByMovieIdAndShowStartTimeLessThanAndShowEndtimeGreaterThan(movieId, ts, ts);
	}

	@GetMapping("/getAll")
	public List<Show> test() {
		System.out.println("LocalTime.now() -" + LocalTime.now());
		System.out.println("LocalTime.now() -" + Timestamp.from(ZonedDateTime.now().toInstant()));
		return showService.findAll();
	}
	
	@GetMapping("/getById")
	public Show getShowById(@RequestParam Integer id) {
		return showService.getShow(id);
	}
	
}
