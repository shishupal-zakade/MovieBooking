package com.threatre.customer.client;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.threatre.customer.records.Show;

@HttpExchange
public interface ShowClient {

	@GetExchange("/theatre/show/getRunningShowWithMovieIdAndTime")
	public List<Show> getRunningShowWithMovieIdAndTime(@RequestParam String movieId, @RequestParam String date);
}
