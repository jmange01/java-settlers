package com.settlers.gamelogic.vo;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.settlers.gamelogic.gamemanager.SettlersGameProperties.GamePiece;
import com.settlers.gamelogic.gamestate.board.Road;
import com.settlers.gamelogic.gamestate.board.Settlement;
import com.settlers.gui.Tile.TileType;

public class Player {
	
	private String name;
	private int playerIndex;
	private boolean isActive = false;
	
	List<Settlement> ownedSettlements;
	List<Road> ownedRoads;
	Stockpile stockpile;
	private BufferedImage settlementImage;

	//Temp variable for setting color of roads
	public Color playerColor;

	public Player(String name, String color) {
		this.name = name;
		this.ownedSettlements = new ArrayList<Settlement>();
		this.ownedRoads = new ArrayList<Road>();
		this.stockpile = new Stockpile();
		//Retrieves the correct color via reflection. Sets the color to black if the correct value can't be parsed.
		try {
			Field f = Color.class.getField(color.toUpperCase());
			playerColor = (Color)f.get(null);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			playerColor = Color.BLACK;
		}
		
		try {
			String fileUrl = "resources/settlement_" + color.toLowerCase() + ".png";
			this.settlementImage = ImageIO.read(new File(fileUrl));
		} catch (IOException e) {
			//TODO: Attempt to load a default icon, then throw an exception as a last resort, if this fails, something is definitely broken.
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
		this.stockpile.useSupplies(GamePiece.SETTLEMENT);
		this.ownedSettlements.add(s);
	}
	
	public void giveFreeSettlement() {
		this.stockpile.giveFreeSettlement();
	}
	
	public void giveFreeRoad() {
		this.stockpile.giveFreeRoad();
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