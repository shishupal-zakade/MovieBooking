package com.threatre.show.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.threatre.show.entity.Show;
import com.threatre.show.repository.ShowRepository;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	private ShowRepository repository;
	
	@Override
	public List<Show> findByShowStartTimeLessThanAndShowEndtimeGreaterThan(Timestamp from, Timestamp from2) {
		return repository.findByShowStartTimeLessThanAndShowEndtimeGreaterThan(from, from2);
	}

	@Override
	public Object updateShow(Show show) {
		
		return repository.save(show);
	}

	@Override
	public Object createShow(Show show) {
		
		return repository.save(show);
	}

	@Override
	public void deleteShow(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<Show> findByMovieIdAndShowStartTimeLessThanAndShowEndtimeGreaterThan(String movieId, Timestamp ts,
			Timestamp ts2) {
		
		return repository.findByMovieIdAndShowStartTimeLessThanAndShowEndtimeGreaterThan(movieId, ts, ts2);
	}

	@Override
	public List<Show> findAll() {
		
		return repository.findAll();
	}

	@Override
	public Show getShow(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	 
}
