package com.settlers.gamelogic.vo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.settlers.gamelogic.gamestate.board.Road;
import com.settlers.gamelogic.gamestate.board.Settlement;
import com.settlers.gui.Tile.TileType;

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
			this.settlementImage = ImageIO.read(new File("resources/settlement_red.png"));
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
	
	public void updateStockpile(TileType resource) {
		this.stockpile.addResource(resource);
	}
	
	public BufferedImage getSettlementImage() {
		return this.settlementImage;
	}
	
	public String reportResources() {
		StringBuilder sb = new StringBuilder();
		sb.append("Brick: " + this.stockpile.brick + "\n");
		sb.append("Ore: " + this.stockpile.ore + "\n");
		sb.append("Sheep: " + this.stockpile.sheep + "\n");
		sb.append("Wheat: " + this.stockpile.wheat + "\n");
		sb.append("Wood: " + this.stockpile.wood);
		
		return sb.toString();
	}
	
}