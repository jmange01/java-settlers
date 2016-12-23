package com.settlers.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gui.renderer.BoardRenderer;

public class GameContainerFactory {
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
	
	private static GameContainer buildGamePlayContainer(SettlersGameState state) {
		GameContainer container = generateStandardContainer();
		
		container.addGamePanel(new BoardPanel(new BoardRenderer(state.getBoard()), state));
		container.addGamePanel(new ScorePanel(state));
		container.addGamePanel(new DiceRollPanel(state));
		container.addGamePanel(new EndTurnPanel());
		
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