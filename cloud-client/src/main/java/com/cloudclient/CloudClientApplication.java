package com.cloudclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CloudClientApplication {
	
	@Value("${app.env}")
    private String envName;
	
	public static void main(String[] args) {
		SpringApplication.run(CloudClientApplication.class, args);
	}
	
	@GetMapping(
		      value = "/which-env",  
		      produces = MediaType.TEXT_PLAIN_VALUE)
		    public String whoami() {
		        return String.format("Hello! You are on %s enviromnment.", envName);
		    }
}
