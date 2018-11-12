package com.skilldistillery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightTrackerRestApplication extends SpringBootServletInitializer {

	@Override
	  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	    return application.sources(FlightTrackerRestApplication.class);
	  }
	public static void main(String[] args) {
		SpringApplication.run(FlightTrackerRestApplication.class, args);
	}
}
