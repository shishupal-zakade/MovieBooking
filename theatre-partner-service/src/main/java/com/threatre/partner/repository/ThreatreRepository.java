package com.threatre.partner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.threatre.partner.entity.Threatre;

public interface ThreatreRepository extends JpaRepository<Threatre, Integer> {
	public List<Threatre> findByCity(String city);

	public List<Threatre> findByCityAndIdIn(String city, List<Integer> id);

}