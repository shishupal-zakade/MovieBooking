package com.threatre.booking.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threatre.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	public Booking findByStatusAndSeatRowNumberAndShowId(String status, Map<String, Integer> seatRowNumbers, String showId);
	
//	public List<Booking> findByShowStartTimeLessThanAndShowEndtimeGreaterThan(Timestamp time,Timestamp time1);


}