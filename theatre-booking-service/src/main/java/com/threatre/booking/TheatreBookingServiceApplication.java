package com.threatre.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TheatreBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatreBookingServiceApplication.class, args);
	}

}
