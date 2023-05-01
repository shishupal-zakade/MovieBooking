package com.threatre.inventory.entity;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inventory")
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "show_id")
	private String showId;

	@Column(name = "movie_id")
	private String movieId;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name = "seat")
	private List<Map<String, Integer>> seatRowNumbers;

	public Inventory() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the showId
	 */
	public String getShowId() {
		return showId;
	}

	/**
	 * @param showId the showId to set
	 */
	public void setShowId(String showId) {
		this.showId = showId;
	}

	/**
	 * @return the movieId
	 */
	public String getMovieId() {
		return movieId;
	}

	/**
	 * @param movieId the movieId to set
	 */
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	/**
	 * @return the seatRowNumbers
	 */
	public List<Map<String, Integer>> getSeatRowNumbers() {
		return seatRowNumbers;
	}

	/**
	 * @param seatRowNumbers the seatRowNumbers to set
	 */
	public void setSeatRowNumbers(List<Map<String, Integer>> seatRowNumbers) {
		this.seatRowNumbers = seatRowNumbers;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", showId=" + showId + ", movieId=" + movieId + ", seatRowNumbers="
				+ seatRowNumbers + "]";
	}
	
	
 

}