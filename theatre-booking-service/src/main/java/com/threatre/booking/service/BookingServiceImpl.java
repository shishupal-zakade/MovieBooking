package com.threatre.booking.service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.threatre.booking.client.ShowClient;
import com.threatre.booking.entity.Booking;
import com.threatre.booking.exception.BookingAlreadyExistsException;
import com.threatre.booking.records.Show;
import com.threatre.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingServiceImpl.class);
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private ShowClient showClient;

	/**
	 * Method book the ticket
	 */
	@Transactional
	public Booking createBooking(Booking booking) throws BookingAlreadyExistsException {
		Booking existingBooking = bookingRepository.findByStatusAndSeatRowNumberAndShowId("ACTIVE",
				booking.getSeatRowNumber(), booking.getShowId());
		if (null != existingBooking) {
			throw new BookingAlreadyExistsException("Booking Failed. Booking already exist");
		}
		Show show = showClient.getShowById(booking.getShowId());
		LOGGER.info("Payment Amount -" + show.price());
		// TODO: Get the offers from Offer service and apply below discount
		Double paymentAmount = show.dayPart().equals("AFTERNOON") ? (show.price() - show.price() * 0.20) : show.price();
		LOGGER.info("Final Payment Amount -" + paymentAmount);
		// TODO: MAKE PAYMENT Service call for paymentAmount, IF it returns the Response
		// code 200 and success message the retrun else throw an exception
		booking.setPrice(paymentAmount);
		return bookingRepository.save(booking);
	}

	@Transactional
	public List<Booking> createBulkBooking(List<Booking> bookings) throws BookingAlreadyExistsException {
		int i = 1;
		Double finalPaymentAmount = 0.0;
		for (Booking booking : bookings) {
			Booking existingBooking = bookingRepository.findByStatusAndSeatRowNumberAndShowId("ACTIVE",
					booking.getSeatRowNumber(), booking.getShowId());
			if (null != existingBooking) {
				throw new BookingAlreadyExistsException("Booking Failed. Booking already exist");
			}
			Show show = showClient.getShowById(booking.getShowId());
			LOGGER.info("Payment Amount -" + show.price());
			// TODO: Get the offers from Offer service and apply below discount
			Double paymentAmount = i % 3 == 0 ? (show.price() - show.price() * 0.50) : show.price();
			LOGGER.info("Discounted Payment Amount -" + paymentAmount);
			// TODO: MAKE PAYMENT Service call for paymentAmount, IF it returns the Response
			// code 200 and success message the retrun else throw an exception
			booking.setPrice(paymentAmount);
			finalPaymentAmount += paymentAmount;
			bookingRepository.save(booking);
			i++;
		}
		// TODO: Get the offers from Offer service and apply discount like above method
		LOGGER.info("Total Payment Amount -" + finalPaymentAmount);

		// TODO: MAKE PAYMENT Service call, IF it returns the Response code 200 and
		// success message the retrun else throw an exception
		return bookings;
	}

	@Override
	public List<Booking> getAllBooking() {
		return bookingRepository.findAll();
	}

}