package com.feliser.boxes.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.feliser.boxes.models.GameState;
import com.feliser.boxes.models.StateRequest;
import com.feliser.boxes.services.GameService;

@Controller
public class UpdateController {
	
	@MessageMapping("/request")
	@SendTo("/gamestate/updates")
	public GameState update(StateRequest sr) throws Exception {
		GameService.updateGameState(sr);
		return GameService.getGameState();
	}
 
}
