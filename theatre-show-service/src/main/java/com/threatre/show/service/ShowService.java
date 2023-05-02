package com.threatre.show.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.threatre.show.entity.Show;

@Service
public interface ShowService {

	List<Show> findByShowStartTimeLessThanAndShowEndtimeGreaterThan(Timestamp from, Timestamp from2);

	Object updateShow(Show show);

	Object createShow(Show show);

	void deleteShow(Integer id);

	List<Show> findByMovieIdAndShowStartTimeLessThanAndShowEndtimeGreaterThan(String movieId, Timestamp ts,
			Timestamp ts2);

	List<Show> findAll();

}
