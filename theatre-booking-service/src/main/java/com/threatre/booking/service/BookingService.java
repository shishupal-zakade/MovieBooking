package com.threatre.booking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.threatre.booking.entity.Booking;
import com.threatre.booking.exception.BookingAlreadyExistsException;

@Service
public interface BookingService {
	
	public Booking createBooking(Booking booking) throws BookingAlreadyExistsException;
	
	public List<Booking> createBulkBooking(List<Booking> booking) throws BookingAlreadyExistsException;
	
	public List<Booking> getAllBooking();

}