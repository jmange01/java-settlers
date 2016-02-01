package com.settlers.gamelogic.gamemanager;

import java.util.List;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gamelogic.gamestate.board.Hexagon;

public class GameManager {
	
	SettlersGameState state;
	
	public GameManager(SettlersGameState state) {
		this.state = state;
	}
	
	public List<Hexagon> getGameBoardTiles() {
		return this.state.getBoard().getTiles();
	}
}
