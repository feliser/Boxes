package com.feliser.boxes;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.feliser.boxes.services.GameService;

@Component
public class BoxInitializer {

	@PostConstruct
	private void init() {
		GameService.init();
	}
}
