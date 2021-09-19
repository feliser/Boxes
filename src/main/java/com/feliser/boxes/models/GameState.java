package com.feliser.boxes.models;

public class GameState {
	
	private int totalNum, remainingNum, boxNum;
	
	public GameState() { 
		// fresh game values
		totalNum = 0;
		remainingNum = 1;
		boxNum = 1;
	}
	
	public GameState(int totalNum, int remainingNum, int boxNum) {
		this.totalNum = totalNum;
		this.remainingNum = remainingNum;
		this.boxNum = boxNum;
	}
	
	public int getTotalNum() {
		return totalNum;
	}
	
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	
	public int getRemainingNum() {
		return remainingNum;
	}
	
	public void setRemainingNum(int remainingNum) {
		this.remainingNum = remainingNum;
	}
	
	public int getBoxNum() {
		return boxNum;
	}
	
	public void setBoxNum(int boxNum) {
		this.boxNum = boxNum;
	}
}
