package com.settlers.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gui.renderer.BoardRenderer;

public class GameContainerFactory {
	//The current state of the Game window (e.g. Menu, game setup, gameplay)
	public enum Stage {
		SETUP,
		PLAY,
		END;
	}
	
	protected static GameContainer getContainerInstance(Stage stage, SettlersGameState state, GameWindow window) {
		GameContainer container = null;
		if(Stage.SETUP.equals(stage)) {
			container = buildSetupContainer(state);
		} else if(Stage.PLAY.equals(stage)) {
			container = buildGamePlayContainer(state);
		}
		
		if(container != null) {
			container.setParent(window);
		}
		return container;
	}
	
	private static GameContainer buildSetupContainer(SettlersGameState state) {
		GameContainer container = generateStandardContainer();
		
		container.addGamePanel(new SetupDialog(state));
		
		return container;
	}
	
	/**
	 * Builds a standard container for a Settlers game
	 * @return a GameContainer component to be added to the GameWindow
	 */
	private static GameContainer buildGamePlayContainer(SettlersGameState state) {
		GameContainer container = generateStandardContainer();
		
		container.addGamePanel(new BoardPanel(new BoardRenderer(state.getBoard()), state));
		container.addGamePanel(new ScorePanel(state));
		container.addGamePanel(new DiceRollPanel(state));
		container.addGamePanel(new EndTurnPanel());
		container.addGamePanel(new ResourcePanel(state));
		
		return container;
		
	}
	
	private static GameContainer generateStandardContainer() {
		GameContainer container = new GameContainer();
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800,600));
		panel.setVisible(true);
		panel.setLayout(new FlowLayout());
		container.setPanel(panel);
		
		return container;
	}
}