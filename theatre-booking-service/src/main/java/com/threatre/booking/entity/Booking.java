package com.threatre.booking.entity;

import java.sql.Timestamp;
import java.util.Date;
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
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "theatre_id")
	private String theatreId;

	@Column(name = "movie_id")
	private String movieId;

	@Column(name = "date")
	private Date date;

	@Column(name = "show_id")
	private String showId;

	@Column(name = "status")
	private String status;

	@JdbcTypeCode(SqlTypes.JSON)
	@Column(name = "seat_row_numbers")
	private Map<String, Integer> seatRowNumber;
	
	public Booking() {
		super();
	}

	public Booking(Integer id, String theatreId, String movieId, Date date, String showId, String status,
			Map<String, Integer> seatRowNumbers) {
		super();
		this.id = id;
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.date = date;
		this.showId = showId;
		this.status = status;
		this.seatRowNumber = seatRowNumbers;
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
	 * @return the theatreId
	 */
	public String getTheatreId() {
		return theatreId;
	}

	/**
	 * @param theatreId the theatreId to set
	 */
	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	 
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
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
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	 
 
	/**
	 * @return the seatRowNumber
	 */
	public Map<String, Integer> getSeatRowNumber() {
		return seatRowNumber;
	}

	/**
	 * @param seatRowNumber the seatRowNumber to set
	 */
	public void setSeatRowNumber(Map<String, Integer> seatRowNumber) {
		this.seatRowNumber = seatRowNumber;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", theatreId=" + theatreId + ", movieId=" + movieId + ", date=" + date
				+ ", showId=" + showId + ", status=" + status + "]";
	}

}