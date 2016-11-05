package com.settlers.gui.listener;

import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.vo.Player;

public class GameAction {
	public enum ActionType {
		BUILD_SETTLEMENT,
		BUILD_ROAD,
		BUILD_CITY,
		ROLL_DICE;
	}
	
	private ActionType type;
	private Player p;
	private Node location;
	
	public GameAction(ActionType type) {
		this.type = type;
	}
	
	public ActionType getType() {
		return this.type;
	}

	public Node getLocation() {
		return location;
	}

	public void setLocation(Node location) {
		this.location = location;
	}
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	public Player getPlayer() {
		return this.p;
	}
}
