package com.feliser.boxes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.feliser.boxes.services.GameService;

@SpringBootApplication
public class BoxesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoxesApplication.class, args);
	}
}
