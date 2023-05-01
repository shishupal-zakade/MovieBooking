package com.threatre.customer.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.threatre.customer.records.Theatre;

@Service
public interface CustomerService {

	public List<Theatre> getTheatreByCityAndMovieAndDate(String movieId, String city, Timestamp date);
}