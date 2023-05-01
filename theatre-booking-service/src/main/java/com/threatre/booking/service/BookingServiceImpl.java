package com.threatre.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threatre.booking.entity.Booking;
import com.threatre.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl  implements BookingService{
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public Booking createBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}
	

}