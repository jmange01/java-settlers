package com.settlers.gui.listener;

import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.vo.Player;

public class GameAction {
	public enum ActionType {
		END_STAGE,
		BUILD_SETTLEMENT,
		BUILD_ROAD,
		BUILD_CITY,
		ROLL_DICE,
		END_TURN;
	}
	
	private ActionType type;
	private Player actor;
	private Node location;
	
	public GameAction(ActionType type, Player actor) {
		this.type = type;
		this.actor = actor;
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
		this.actor = actor;
	}
	
	public Player getPlayer() {
		return this.actor;
	}
}
