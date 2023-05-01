package com.threatre.customer.records;

public class Theatre{
	private Integer id;
	private String name;
	private String address;
	private String city;
	private Show show;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the show
	 */
	public Show getShow() {
		return show;
	}
	/**
	 * @param show the show to set
	 */
	public void setShow(Show show) {
		this.show = show;
	}
	@Override
	public String toString() {
		return "Theatre [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", show=" + show
				+ "]";
	}
	
	
} 
