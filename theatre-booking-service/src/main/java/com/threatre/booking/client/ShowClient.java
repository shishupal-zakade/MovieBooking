package com.threatre.booking.client;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.threatre.booking.records.Show;

@HttpExchange
public interface ShowClient {

	@GetExchange("/theatre/show/getById")
	public Show getShowById(@RequestParam Integer id);
}
