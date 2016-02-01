package com.settlers.main;

import javax.swing.JFrame;

import com.settlers.gamelogic.gamemanager.GameManager;
import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gui.GameWindow;

public class SOJGame {
	public void init(){
		SettlersGameState gameState = new SettlersGameState();
		GameManager manager = new GameManager(gameState);
		JFrame frame = new GameWindow(manager);
	}
}
