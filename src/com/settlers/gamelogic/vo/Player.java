package com.settlers.gamelogic.vo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.settlers.gamelogic.gamestate.board.Road;
import com.settlers.gamelogic.gamestate.board.Settlement;

public class Player {
	
	String name;
	int freeSettlements;
	int freeCities;
	int freeRoads;
	int points;
	int knights;
	private boolean isActive = false;
	
	List<Settlement> ownedSettlements;
	List<Road> ownedRoads;
	Stockpile stockpile;
	private BufferedImage settlementImage;

	public Player(String name) {
		this.name = name;
		this.freeSettlements = 5;
		this.freeCities = 4;
		this.freeRoads = 15;
		this.points = 0;
		this.knights = 0;
		this.ownedSettlements = new ArrayList<Settlement>();
		this.ownedRoads = new ArrayList<Road>();
		this.stockpile = new Stockpile();
		
		try {
			this.settlementImage = ImageIO.read(new File("resources/settlement.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getPlayerName() {
		return this.name;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public void playSettlement(Settlement s) {
		this.freeSettlements--;
		this.ownedSettlements.add(s);
	}
	
	public BufferedImage getSettlementImage() {
		return this.settlementImage;
	}
	
}