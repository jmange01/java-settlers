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
		END_TURN,
		START_ROAD;
	}
	
	private Player player;
	public ActionType type;
	public Node location;
	public Node secondaryLocation;
	
	public GameAction(ActionType type, Player player) {
		this.type = type;
		this.player = player;
	}
	
	public Player getPlayer() {
		return this.player;
	}
}
