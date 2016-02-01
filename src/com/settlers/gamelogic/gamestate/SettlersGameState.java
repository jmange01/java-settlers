package com.settlers.gamelogic.gamestate;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.BoardBuilder;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gamelogic.gamestate.board.StandardBoardBuilder;
import com.settlers.gamelogic.gamestate.deck.Deck;
import com.settlers.gamelogic.gamestate.deck.DevCardDeck;
import com.settlers.gamelogic.vo.Player;

public class SettlersGameState {
	private SettlersBoard board;
	public SettlersGameState(){
		List<Player> players = new ArrayList<Player>();
		BoardBuilder builder = new StandardBoardBuilder();
		board = builder.buildBoard();
		Deck deck = new DevCardDeck(new File("properties" + System.getProperty("file.separator") + "devDeck.csv"));
		//deck.shuffle();
	}
	
	public SettlersBoard getBoard() {
		return board;
	}
	
	public void setBoard(SettlersBoard board) {
		this.board = board;
	}
}
