package com.threatre.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.threatre.booking.entity.Booking;

@Service
public interface BookingService {
	
	public Booking createBooking(Booking booking);
	
	public List<Booking> getAllBooking();

}