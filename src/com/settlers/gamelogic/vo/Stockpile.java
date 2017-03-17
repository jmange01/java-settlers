package com.settlers.gamelogic.vo;

import java.util.List;

import com.settlers.gamelogic.gamemanager.SettlersGameProperties.GamePiece;
import com.settlers.gamelogic.gamestate.deck.Card;
import com.settlers.gui.Tile.TileType;

/*******************************************************
 * The player's bank of supplies - all of the nuts and 
 * bolts required to play the game, including resources,
 * held cards, available game pieces, etc.
 * 
 * @author Jeff
 *
 *******************************************************/
public class Stockpile {
	private int brick = 0;
	private int wheat = 0;
	private int sheep = 0;
	private int wood = 0;
	private int ore = 0;
	
	private int freeSettlements = 0;
	private int stockSettlements = 5;
	
	List<Card> devCards;
	
	/**
	 * Adds a resource to the bank depending on the type passed in.
	 * @param the type of the tile supplying the resource.
	 */
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
	
	public void useSupplies(GamePiece piece) {
		int[] required = piece.getCost();
		this.brick -= required[0];
		this.wheat -= required[1];
		this.sheep -= required[2];
		this.wood -= required[3];
		this.ore -= required[4];
	}
	
	/**
	 * Adds a free settlement to the stockpile without charging the 
	 * resources normally required. Used primarily when setting up the
	 * game.
	 */
	public void giveFreeSettlement() {
		this.freeSettlements++;
	}
	
	/**
	 * Decrements the free settlements by one.
	 * @return a boolean indicating whether the decrement was successful
	 */
	public boolean useFreeSettlement() {
		return this.freeSettlements > 0 ? this.freeSettlements-- >= 0 : false;
	}
	
	/**
	 * Determines whether the stockpile has sufficient supplies to produce 
	 * the indicated gamepiece(or development card).
	 * Yes, this way of doing it is really indirect, but it prevents
	 * exposure of the hidden stockpile values.
	 * @param an enumerated GamePiece
	 * @return true if there are sufficient resources; else false
	 */
	public boolean hasSufficientSupplies(GamePiece gamepiece) {
		return this.useFreeSettlement() 
				|| gamepiece.isPlayable(this.brick, this.wheat, this.sheep, this.wood, this.ore);
	}
	
	/**
	 * The irony is not lost on me. Since I've avoided writing getters
	 * for the "hidden" resource values, I'm allowing package level access
	 * to this method so that the GUI can print the contents of the 
	 * stockpile by requesting them through the Player. Still better 
	 * than exposing getters...? ¯\_(ツ)_/¯
	 * @return the String representation of the stockpile's *ahem* contents
	 */
	protected String reportResources() {
		StringBuilder sb = new StringBuilder();
		sb.append("Brick: " + this.brick + "\n");
		sb.append("Ore: " + this.ore + "\n");
		sb.append("Sheep: " + this.sheep + "\n");
		sb.append("Wheat: " + this.wheat + "\n");
		sb.append("Wood: " + this.wood);
		
		return sb.toString();
	}
}
