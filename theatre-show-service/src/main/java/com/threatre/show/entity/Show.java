package com.threatre.show.entity;

import java.sql.Timestamp;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "theatre")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "theatre_id")
	private String theatreId;

	@Column(name = "movie_id")
	private String movieId;

	@Column(name = "date")
	private Date date;

	@Column(name = "show_start_time")
	private Timestamp showStartTime;
	
	@Column(name = "show_end_time")
	private Timestamp showEndtime;
	
	@Column(name = "dayPart")
	private String dayPart;
	
	@Column(name = "price")
	private Double price;

	
	public Show() {
		super();
	}


	public Show(Integer id, String theatreId, String movieId, Date date, Timestamp showStartTime, Timestamp showEndtime,
			String dayPart, Double price) {
		super();
		this.id = id;
		this.theatreId = theatreId;
		this.movieId = movieId;
		this.date = date;
		this.showStartTime = showStartTime;
		this.showEndtime = showEndtime;
		this.dayPart = dayPart;
		this.price = price;
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
	 * @return the showStartTime
	 */
	public Timestamp getShowStartTime() {
		return showStartTime;
	}


	/**
	 * @param showStartTime the showStartTime to set
	 */
	public void setShowStartTime(Timestamp showStartTime) {
		this.showStartTime = showStartTime;
	}


	/**
	 * @return the showEndtime
	 */
	public Timestamp getShowEndtime() {
		return showEndtime;
	}


	/**
	 * @param showEndtime the showEndtime to set
	 */
	public void setShowEndtime(Timestamp showEndtime) {
		this.showEndtime = showEndtime;
	}


	/**
	 * @return the dayPart
	 */
	public String getDayPart() {
		return dayPart;
	}


	/**
	 * @param dayPart the dayPart to set
	 */
	public void setDayPart(String dayPart) {
		this.dayPart = dayPart;
	}


	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Show [id=" + id + ", theatreId=" + theatreId + ", movieId=" + movieId + ", date=" + date
				+ ", showStartTime=" + showStartTime + ", showEndtime=" + showEndtime + ", dayPart=" + dayPart
				+ ", price=" + price + "]";
	}
	
	
	

}