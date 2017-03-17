package com.settlers.gamelogic.vo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.settlers.gamelogic.gamemanager.SettlersGameProperties.GamePiece;
import com.settlers.gamelogic.gamestate.board.Road;
import com.settlers.gamelogic.gamestate.board.Settlement;
import com.settlers.gui.Tile.TileType;

public class Player {
	
	private String name;
	/*TODO: Move this to stockpile*/
	private int freeSettlements;
	private int freeCities;
	private int freeRoads;
	private int points;
	private int knights;
	/*******************************/
	private int playerIndex;
	private boolean isActive = false;
	
	List<Settlement> ownedSettlements;
	List<Road> ownedRoads;
	Stockpile stockpile;
	private BufferedImage settlementImage;

	public Player(String name, String color) {
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
			String fileUrl = "resources/settlement_" + color.toLowerCase() + ".png";
			this.settlementImage = ImageIO.read(new File(fileUrl));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getPlayerName() {
		return this.name;
	}
	
	public int getPlayerIndex() {
		return this.playerIndex;
	}
	
	public void setPlayerIndex(int index) {
		this.playerIndex = index;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public boolean isActive() {
		return this.isActive;
	}
	
	public void playSettlement(Settlement s) {
		if(this.freeSettlements > 0) {
			this.freeSettlements--;
		} else {
			this.stockpile.useSupplies(GamePiece.SETTLEMENT);
		}
		this.ownedSettlements.add(s);
	}
	
	public void giveFreeSettlement() {
		this.stockpile.giveFreeSettlement();
	}
	
	public void updateStockpile(TileType resource) {
		this.stockpile.addResource(resource);
	}
	
	public BufferedImage getSettlementImage() {
		return this.settlementImage;
	}
	
	public boolean checkResources(GamePiece piece) {
		return this.stockpile.hasSufficientSupplies(piece);
	}
	
	public String reportResources() {
		return this.stockpile.reportResources();
	}
	
}