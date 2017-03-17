package com.settlers.gamelogic.gamemanager;

import com.settlers.gamelogic.gamemanager.SettlersGameProperties.GamePiece;
import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.gamestate.SettlersGameState.GameStage;
import com.settlers.gamelogic.gamestate.SettlersGameState.PlayStep;
import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.gamestate.board.Settlement;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gamelogic.vo.Player;
import com.settlers.gui.Tile;
import com.settlers.gui.listener.GameAction;
import com.settlers.gui.listener.GameAction.ActionType;

/**
 * Controller for the game logic. Manages play order and provides an interface layer
 * for modifications to the game state.
 * 
 * @author Jeff
 *
 */
public class GameManager {
	
	SettlersGameState state;
	
	public GameManager(SettlersGameState state) {
		this.state = state;
	}
	
	public SettlersBoard getGameBoard() {
		return this.state.getBoard();
	}
	
	public void update(GameAction action) {
		if(ActionType.BUILD_SETTLEMENT.equals(action.getType())) {
			this.addSettlement(action);
		} else if(PlayStep.ROLL.equals(state.getCurrentTurnStep()) && 
				ActionType.ROLL_DICE.equals(action.getType())) {
			int roll = this.state.getDice().roll();
			this.assignResources(roll);
			this.state.setLastRoll(roll);
			this.state.nextStep();
		} else if(ActionType.END_TURN.equals(action.getType())) {
			if(GameStage.SETUP.equals(state.getCurrentStage())) {
				if(!state.playOrderReversed() && state.getActivePlayer().getPlayerIndex() == state.getPlayers().size() - 1) {
					state.reversePlayOrder();
					for(Player p : state.getPlayers()) {
						p.giveFreeSettlement();
					}
				} else if(state.getActivePlayer() == state.getPlayers().get(0) && state.playOrderReversed()) {
					state.reversePlayOrder();
					state.advanceStage();
				} else {
					state.activateNextPlayer();
				}
			} else {
				state.activateNextPlayer();
			}
		}
	}
	
	private void assignResources(int roll) {
		SettlersBoard board = this.state.getBoard();
		for(Settlement s : board.getSettlements()) {
			if(s.getNode().getResourceMap().containsKey(roll)) {
				for(Tile t : s.getNode().getResourceMap().get(roll)) {
					s.getOwner().updateStockpile(t.getTileType());
				}
			}
		}
	}

	public synchronized void addSettlement(GameAction action) {
		Node n = action.getLocation();
		if(!n.hasSettlement() && action.getPlayer().checkResources(GamePiece.SETTLEMENT)) {
			Settlement s = new Settlement(n, action.getPlayer());
			this.state.getBoard().addSettlement(s);
			action.getPlayer().playSettlement(s);
		}
	}
}
