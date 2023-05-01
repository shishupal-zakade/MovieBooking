package com.threatre.customer.service;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threatre.customer.client.ShowClient;
import com.threatre.customer.client.TheatreClient;
import com.threatre.customer.records.Show;
import com.threatre.customer.records.Theatre;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private static Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

	@Autowired
	TheatreClient theatreClient;
	
	@Autowired
	ShowClient showClient;
	
	@Override
	public List<Theatre> getTheatreByCityAndMovieAndDate(String movieId, String city,
			Timestamp date) {
		LOGGER.info("Executing Scenario 1: Browing the theatres which are running selected show in the town at specific date and time");
		List<Show> show =(showClient.getRunningShowWithMovieIdAndTime(movieId, date.toString()));
//		return client.getByCityAndIds(city, null);
		List<Theatre> theatres = (theatreClient.getByCity(city));
		for (Theatre theatre : theatres) {
			theatre.setShow(show.stream().filter(p -> p.theatreId() ==theatre.getId()).findAny().orElse(null));
		}
		LOGGER.info("Executing Scenario 1 Output: "+theatres.toString());
		return theatres;
	}
} 