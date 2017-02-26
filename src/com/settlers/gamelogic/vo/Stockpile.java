package com.settlers.gamelogic.vo;

import java.util.List;

import com.settlers.gamelogic.gamestate.deck.Card;
import com.settlers.gui.Tile.TileType;

public class Stockpile {
	int brick = 0;
	int ore = 0;
	int sheep = 0;
	int wheat = 0;
	int wood = 0;
	
	List<Card> devCards;
	
	public void addResource(TileType t) {
		if(TileType.BRICK.equals(t)) {
			brick++;
		} else if(TileType.ORE.equals(t)) {
			ore++;
		} else if(TileType.SHEEP.equals(t)) {
			sheep++;
		} else if(TileType.WHEAT.equals(t)) {
			wheat++;
		} else if(TileType.LUMBER.equals(t)) {
			wood++;
		}
			
	}
}
