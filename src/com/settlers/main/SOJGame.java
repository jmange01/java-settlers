package com.settlers.main;

import com.settlers.gamelogic.gamemanager.GameManager;
import com.settlers.gamelogic.gamestate.SettlersGameState;
import com.settlers.gui.GameWindow;
import com.settlers.gui.listener.GameAction;

/**
 * The main game loop for A Settlers game. Simply follows the following steps:
 *     1) Get any available events from the GUI
 *     2) Dispatch an event to the game logic if one is returned
 *     3) Refresh the GUI (The GUI holds a reference to the game state, so it automatically handles
 *        Changes to the state).
 *     4) Wait .1 seconds before executing the next iteration through the loop.
 *     
 * @author Jeff
 *
 */
public class SOJGame implements Runnable {
	
	GameWindow gui;
	GameManager manager;
	public SOJGame(){
		SettlersGameState gameState = new SettlersGameState();
		gui = new GameWindow(gameState);
		manager = new GameManager(gameState);
	}

	//TODO: Need to eventually add a main menu for selecting local/online play, macro settings, etc.
	@Override
	public void run() {
		while(true) {
			GameAction action = gui.getAction();
			if(action != null) {
				manager.update(action);
			}
			gui.update();
			gui.pack();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}
}
