package com.threatre.customer.client;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import com.threatre.customer.records.Theatre;

@HttpExchange
public interface TheatreClient {

	@GetExchange("/theatre/partner/findTheatres/{city}")
	public List<Theatre> getByCityAndIds(@PathVariable String city, @RequestParam List<Integer> id);
	
	@GetExchange("/theatre/partner/getByCity/{city}")
	public List<Theatre> getByCity(@PathVariable String city) ;
}
