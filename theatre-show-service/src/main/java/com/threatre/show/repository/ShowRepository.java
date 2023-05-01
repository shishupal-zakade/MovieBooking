package com.threatre.show.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threatre.show.entity.Show;

public interface ShowRepository extends JpaRepository<Show, Integer> {

	public List<Show> findByShowStartTimeLessThanAndShowEndtimeGreaterThan(Timestamp time, Timestamp time1);

	public List<Show> findByMovieIdAndShowStartTimeLessThanAndShowEndtimeGreaterThan(String movieId, Timestamp time,
			Timestamp time1);

}