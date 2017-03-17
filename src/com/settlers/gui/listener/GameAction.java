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
	private Player player;
	private Node location;
	
	public GameAction(ActionType type, Player player) {
		this.type = type;
		this.player = player;
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
	
	public Player getPlayer() {
		return this.player;
	}
}
