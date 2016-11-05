package com.settlers.gamelogic.gamemanager;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.gamestate.board.Settlement;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.listener.GameAction.ActionType;

public class GameManager {
	
	SettlersGameState state;
	
	public GameManager(SettlersGameState state) {
		this.state = state;
	}
	
	public SettlersBoard getGameBoard() {
		return this.state.getBoard();
	}

	public synchronized void addSettlement(GameAction action) {
		Node n = action.getLocation();
		Settlement s = new Settlement((int)n.getLocation().getX(),(int)n.getLocation().getY(), action.getPlayer().getSettlementImage());
		this.state.getBoard().addSettlement(s);
		action.getPlayer().playSettlement(s);
	}
	
	public void update(GameAction action) {
		if(ActionType.BUILD_SETTLEMENT.equals(action.getType())) {
			this.addSettlement(action);
		}
	}
}
