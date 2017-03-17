package com.settlers.gamelogic.gamestate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.settlers.gamelogic.gamestate.board.BoardBuilder;
import com.settlers.gamelogic.gamestate.board.SettlersBoard;
import com.settlers.gamelogic.gamestate.board.StandardBoardBuilder;
import com.settlers.gamelogic.vo.Player;
import com.settlers.util.Dice;

/**
 * The representation of a game's state. Composed of the board and various
 * members that represent stateful game characteristics.
 * 
 * @author Jeff
 *
 */
public class SettlersGameState {
	//The current stage of the game
	public enum GameStage {
		SETUP,
		MAIN,
		END
	}
	
	//The steps in a player's turn
	public enum PlayStep {
		ROLL,
		PLAY;
	}
	
	public enum SetupStep {
		PLAY,
		END;
	}
	
	private SettlersBoard board;
	private List<Player> players;
	private GameStage[] stages = {GameStage.SETUP, GameStage.MAIN,GameStage.END};
	private int currentStage = 0;
	private PlayStep[] steps = {PlayStep.ROLL, PlayStep.PLAY};
	private int currentStep = 0;
	private Dice gameDice = new Dice(2, 6);
	
	private int activePlayer = 0;
	private int lastRoll = 0;
	private int turnDirection = 1;
	
	public SettlersGameState(){
		this.players = new ArrayList<Player>();
	}
	
	public void finalizeInitialState() {
		Collections.shuffle(players);
		for(int i = 0; i < players.size(); i++) {
			players.get(i).setPlayerIndex(i);
			players.get(i).giveFreeSettlement();
		}
		players.get(activePlayer).setActive(true);
		BoardBuilder builder = new StandardBoardBuilder();
		board = builder.buildBoard();
//		Deck deck = new DevCardDeck(new File("properties" + System.getProperty("file.separator") + "devDeck.csv"));
		//deck.shuffle();
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
	
	public PlayStep getCurrentTurnStep() {
		return GameStage.SETUP.equals(this.getCurrentStage()) ? PlayStep.PLAY : this.steps[this.currentStep];
	}
	
	public void nextStep() {
		currentStep = currentStep >= steps.length - 1 ? 0 : currentStep + 1;
	}
	
	public Dice getDice() {
		return this.gameDice;
	}
	
	public GameStage getCurrentStage() {
		return this.stages[this.currentStage];
	}
	//TODO: Need logic to handle end of game. For now I'll just let it potentially
	//throw the OoB Exception.
	public void advanceStage() {
		this.currentStage++;
	}
	
	public int getLastRoll() {
		return this.lastRoll;
	}
	
	public void setLastRoll(int roll) {	
		this.lastRoll = roll;
	}
	
	public void reversePlayOrder() {
		this.turnDirection = -this.turnDirection;
	}
	
	public boolean playOrderReversed() {
		return this.turnDirection < 0;
	}
	
	public void activateNextPlayer() {
		this.lastRoll = 0;
		this.players.get(activePlayer).setActive(false);
		this.activePlayer = this.activePlayer + this.turnDirection <= this.players.size() - 1 ? this.activePlayer + this.turnDirection : 0;
		this.players.get(activePlayer).setActive(true);
		this.currentStep = 0;
	}
}
