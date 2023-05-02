package com.threatre.booking.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threatre.booking.entity.Booking;
import com.threatre.booking.exception.BookingAlreadyExistsException;
import com.threatre.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	public Booking createBooking(Booking booking) throws BookingAlreadyExistsException {
		Booking existingBooking = bookingRepository.findByStatusAndSeatRowNumberAndShowId("ACTIVE",
				booking.getSeatRowNumber(), booking.getShowId());
		if (null != existingBooking) {
			throw new BookingAlreadyExistsException("Booking Failed. Booking already exist");
		}
		return bookingRepository.save(booking);
	}

	@Transactional
	public List<Booking> createBulkBooking(List<Booking> bookings) throws BookingAlreadyExistsException {
		for (Booking booking : bookings) {
			Booking existingBooking = bookingRepository.findByStatusAndSeatRowNumberAndShowId("ACTIVE",
					booking.getSeatRowNumber(), booking.getShowId());
			if (null != existingBooking) {
				throw new BookingAlreadyExistsException("Booking Failed. Booking already exist");
			}
			bookingRepository.save(booking);
		}
		return bookings;
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

}