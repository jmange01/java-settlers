package com.settlers.gamelogic.gamemanager;

import com.settlers.gamelogic.gamemanager.SettlersGameProperties.GamePiece;
import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.gamestate.SettlersGameState.GameStage;
import com.settlers.gamelogic.gamestate.SettlersGameState.PlayStep;
import com.settlers.gamelogic.gamestate.board.Node;
import com.settlers.gamelogic.gamestate.board.Road;
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
	
	/**
	 * The heart of the controller. This coordinates the progression of the game and handles various static events in 
	 * the gameplay, such as giving free settlements in set up and assigning collected resources when the dice are rolled.
	 * @param action, the current action on the board
	 */
	public void update(GameAction action) {
		//Nothing happened yet, so no need to do anything.
		if(action == null) {
			return;
		}
		//TODO: The update logic should be split out into encapsulated game stage containers,
		//each of which will control responses to available actions
		if(ActionType.BUILD_SETTLEMENT.equals(action.type)) {
			this.addSettlement(action);
		} else if(ActionType.BUILD_ROAD.equals(action.type)) {
			this.addRoad(action);
		} else if(PlayStep.ROLL.equals(state.getCurrentTurnStep()) 
				&& ActionType.ROLL_DICE.equals(action.type)) {
			int roll = this.state.getDice().roll();
			this.assignResources(roll);
			this.state.setLastRoll(roll);
			this.state.nextStep();
		} else if(PlayStep.PLAY.equals(state.getCurrentTurnStep()) && ActionType.END_TURN.equals(action.type)) {
			if(GameStage.SETUP.equals(state.getCurrentStage())) {
				if(!state.playOrderReversed() && state.getActivePlayer().getPlayerIndex() == state.getPlayers().size() - 1) {
					state.reversePlayOrder();
					for(Player p : state.getPlayers()) {
						p.giveFreeSettlement();
						p.giveFreeRoad();
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
		} else if(GameStage.MAIN.equals(state.getCurrentStage())
				&& PlayStep.PLAY.equals(state.getCurrentTurnStep())) {
			
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
		Node n = action.location;
		if(!n.hasSettlement() && action.getPlayer().checkResources(GamePiece.SETTLEMENT)) {
			Settlement s = new Settlement(n, action.getPlayer());
			n.setSettlement(s);
			this.state.getBoard().addSettlement(s);
			action.getPlayer().playSettlement(s);
		}
	}
	
	/**
	 * Adds a road to the board if the road can be built.
	 * @param action, the triggering game action.
	 */
	public synchronized void addRoad(GameAction action) {
		Node start = action.location;
		Node end = action.secondaryLocation;
		if(canBuildRoad(start, end, action.getPlayer())) {
			Road r = new Road(start, end, action.getPlayer());
			state.getBoard().addRoad(r);
		}
	}
	
	/**
	 * Validates a road-building action. Makes sure that the start and end are adjacent,
	 * that the edge between them is empty, and that the acting player has a settlement 
	 * at one of the two nodes.
	 * @param n1, the first terminal node
	 * @param n2, the second terminal node
	 * @param p, the acting player
	 * @return True if the action is valid, false otherwise
	 */
	private boolean canBuildRoad(Node n1, Node n2, Player p) {
		if(!n1.getAdjacent().contains(n2)) {
			return false;
		} else if(n1.hasRoadTo(n2)) {
			return false;
		} else if(!(n1.hasSettlement() && n1.isOccupiedBy(p)) && !(n2.hasSettlement() && n2.isOccupiedBy(p))) {
			return false;
		} else if(!p.checkResources(GamePiece.ROAD)) {
			return false;
		}
		
		return true;
	}
}
