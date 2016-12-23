package com.settlers.gamelogic.gamestate;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.BoardBuilder;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gamelogic.gamestate.board.StandardBoardBuilder;
import com.settlers.gamelogic.gamestate.deck.Deck;
import com.settlers.gamelogic.gamestate.deck.DevCardDeck;
import com.settlers.gamelogic.vo.Player;

public class SettlersGameState {
	public enum GameStage {
		SETUP,
		IN_PROGRESS,
		END
	}
	
	public enum PlayPhase {
		PRE_GAME,
		IN_GAME
	}
	
	public enum TurnStep {
		ROLL,
		PLAY;
	}
	
	private SettlersBoard board;
	private List<Player> players;
	private PlayPhase currentStage = PlayPhase.PRE_GAME;
	private TurnStep currentStep = TurnStep.ROLL;
	
	private int activePlayer = 0;
	
	public SettlersGameState(){
		this.players = new ArrayList<Player>();
		BoardBuilder builder = new StandardBoardBuilder();
		board = builder.buildBoard();
		Deck deck = new DevCardDeck(new File("properties" + System.getProperty("file.separator") + "devDeck.csv"));
		//deck.shuffle();
	}
	
	public void finalizeInitialState() {
		Collections.shuffle(players);
		players.get(activePlayer).setActive(true);
	}
	
	public SettlersBoard getBoard() {
		return board;
	}
	
	public void setBoard(SettlersBoard board) {
		this.board = board;
	}
	
	public void addPlayer(Player p) {
		this.players.add(p);
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public Player getActivePlayer() {
		return this.players.get(activePlayer);
	}
	
	public TurnStep getCurrentTurnStep() {
		return this.currentStep;
	}
	
	public void activateNextPlayer() {
		this.players.get(activePlayer).setActive(false);
		this.activePlayer = this.activePlayer < this.players.size() - 1 ? this.activePlayer + 1 : 0;
		this.players.get(activePlayer).setActive(true);
	}
}
