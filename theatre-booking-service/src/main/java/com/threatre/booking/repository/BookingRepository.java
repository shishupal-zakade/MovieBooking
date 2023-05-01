package com.threatre.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threatre.booking.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	
//	public List<Booking> findByShowStartTimeLessThanAndShowEndtimeGreaterThan(Timestamp time,Timestamp time1);


}