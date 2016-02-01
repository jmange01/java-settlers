package com.settlers.util;

import java.util.Random;


public class Dice {
	private int number;
	private int sides;
	public Dice(int number, int sides){
		this.number = number;
		this.sides = sides;
	}
	
	public int roll(){
		Random r = new Random();
		int roll = 0;
		for(int i = 0; i<this.number; i++){
			roll += ((r.nextDouble()*this.sides)+1);
		}
		return roll;
	}
}
