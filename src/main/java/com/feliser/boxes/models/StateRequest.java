package com.feliser.boxes.models;

public class StateRequest {
	
	private boolean boxPressed;
	
	public StateRequest() { }
	
	public StateRequest(boolean boxPressed) {
		this.boxPressed = boxPressed;
	}
	
	public boolean getBoxPressed() {
		return boxPressed;
	}
	
	public void setBoxPressed(boolean boxPressed) {
		this.boxPressed = boxPressed;
	}
}
