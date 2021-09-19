package com.feliser.boxes.services;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.feliser.boxes.models.GameState;
import com.feliser.boxes.models.StateRequest;

public class GameService {
	
	private static GameState gameState;
	
	public static void init() {
		System.out.println("******************** START GAMESERVICE INIT *********************");
		gameState = new GameState();
		
		try {
			FileReader fr = new FileReader("/var/lib/tomcat9/webapps/boxes/gamedata.txt");
			Scanner read = new Scanner(fr);
			
			gameState.setTotalNum(read.nextInt());
			gameState.setRemainingNum(read.nextInt());
			gameState.setBoxNum(read.nextInt());		
			
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		updateGameState(new StateRequest(false));
		System.out.println("******************** END GAMESERVICE INIT *********************");
	}
	
	public static GameState getGameState() {
		return gameState;
	}
	
	public static void updateGameState(StateRequest request) {
		// if user clicked
		if(request.getBoxPressed()) {
			
			// increase total clicks
			gameState.setTotalNum(gameState.getTotalNum() + 1);
			
			// decrease remaining count
			gameState.setRemainingNum(gameState.getRemainingNum() - 1);
		}
		
		// new box needed
		if(gameState.getRemainingNum() == 0) {
			
			// increase box count
			gameState.setBoxNum(gameState.getBoxNum() + 1);
			
			// new box takes #box number of clicks to open
			gameState.setRemainingNum(gameState.getBoxNum());
		}
		
		
		// save progress every 25 clicks
		if(gameState.getTotalNum() % 25 == 0) {
			try {
				FileWriter fw = new FileWriter("/var/lib/tomcat9/webapps/boxes/gamedata.txt");
				PrintWriter pw = new PrintWriter(fw);
				
				pw.println(gameState.getTotalNum());
				pw.println(gameState.getRemainingNum());
				pw.println(gameState.getBoxNum());
				
				pw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
